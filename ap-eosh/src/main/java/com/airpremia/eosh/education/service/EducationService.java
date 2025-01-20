package com.airpremia.eosh.education.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.common.dto.HrEmpTransDto;
import com.airpremia.eosh.common.dto.HrWrapperListDto;
import com.airpremia.eosh.common.enums.MessageSendMethodEnum;
import com.airpremia.eosh.components.message.MessageSendComponent;
import com.airpremia.eosh.components.message.SendMessageResponse;
import com.airpremia.eosh.education.controller.CourseSurveyRequest;
import com.airpremia.eosh.education.controller.CourseSurveyResponse;
import com.airpremia.eosh.education.controller.EducationAttendUserRequest;
import com.airpremia.eosh.education.controller.EducationInstructorRequest;
import com.airpremia.eosh.education.controller.EducationListResponse;
import com.airpremia.eosh.education.controller.EducationRequest;
import com.airpremia.eosh.education.controller.EducationResponse;
import com.airpremia.eosh.education.controller.EducationSearchRequest;
import com.airpremia.eosh.education.controller.InstructorEvaluationRequest;
import com.airpremia.eosh.education.controller.InstructorEvaluationResponse;
import com.airpremia.eosh.education.controller.InstructorSelfEvaluationPaperRequest;
import com.airpremia.eosh.education.controller.InstructorSelfEvaluationPaperResponse;
import com.airpremia.eosh.education.controller.SaveInstructorEvaluationRequest;
import com.airpremia.eosh.education.controller.SaveInstructorSelfEvaluationPaperRequest;
import com.airpremia.eosh.education.dto.CourseEvalCountDto;
import com.airpremia.eosh.education.dto.CourseSurveyDto;
import com.airpremia.eosh.education.dto.EducationAttendUserDto;
import com.airpremia.eosh.education.dto.EducationDto;
import com.airpremia.eosh.education.dto.EducationInstructorDto;
import com.airpremia.eosh.education.dto.EducationInstructorUserNamesDto;
import com.airpremia.eosh.education.dto.EducationListDto;
import com.airpremia.eosh.education.dto.InstructorDto;
import com.airpremia.eosh.education.dto.InstructorEvaluationDto;
import com.airpremia.eosh.education.dto.InstructorSelfEvaluationPaperDto;
import com.airpremia.eosh.education.repository.CourseSurveyRepository;
import com.airpremia.eosh.education.repository.EducationAttendUserRepository;
import com.airpremia.eosh.education.repository.EducationInstructorRepository;
import com.airpremia.eosh.education.repository.EducationRepository;
import com.airpremia.eosh.education.repository.InstructorEvaluationRepository;
import com.airpremia.eosh.education.repository.InstructorRepository;
import com.airpremia.eosh.education.repository.InstructorSelfEvaluationPaperRepository;
import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.SlackException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class EducationService {

    private final EducationRepository educationRepository;
    private final EducationInstructorRepository educationInstructorRepository;
    private final EducationAttendUserRepository educationAttendUserRepository;
    private final CourseSurveyRepository courseSurveyRepository;
    private final InstructorEvaluationRepository instructorEvaluationRepository;
    private final InstructorSelfEvaluationPaperRepository instructorSelfEvaluationPaperRepository;
    private final InstructorRepository instructorRepository;
    private final CommonFunction commonFunction;
    private final MessageSendComponent messageSendComponent;

    public Page<EducationListResponse> selectEducationPage(
        EducationSearchRequest educationSearchRequest, Pageable pageable) {

        EducationDto dto =
            new EducationDto(educationSearchRequest);
        Page<EducationListDto> pageDto =
            educationRepository.selectEducationPage(dto, pageable);

        List<Long> educationSeqs = new ArrayList<>();
        for (EducationListDto educationDto : pageDto.getContent()) {
            educationSeqs.add(educationDto.getEducationSeq());
        }

        if (!educationSeqs.isEmpty()) {
            List<CourseEvalCountDto> courseSurveyCount =
                courseSurveyRepository.selectCourseSurveyCount(educationSeqs);
            List<CourseEvalCountDto> instructorEvaluationCount =
                instructorEvaluationRepository.selectInstructorEvaluationCount(educationSeqs);
            List<EducationInstructorUserNamesDto> instructorNames =
                educationInstructorRepository.selectEducationInstructorUserNames(educationSeqs);

            pageDto.getContent().forEach(contentDto -> {
                Long educationSeq = contentDto.getEducationSeq();

                List<CourseEvalCountDto> courseSurveyFilterList =
                    courseSurveyCount.stream().filter(countDto -> countDto.getEducationSeq().equals(educationSeq))
                        .toList();
                List<CourseEvalCountDto> instructorEvaluationFilterList =
                    instructorEvaluationCount.stream()
                        .filter(countDto -> countDto.getEducationSeq().equals(educationSeq))
                        .toList();
                List<EducationInstructorUserNamesDto> instructorUserNamesFilterList =
                    instructorNames.stream()
                        .filter(instructorDto -> instructorDto.getEducationSeq().equals(educationSeq))
                        .toList();

                if (!courseSurveyFilterList.isEmpty()) {
                    contentDto.setCourseSurveyCnt(courseSurveyFilterList.getFirst().getCourseEvalCount());
                }
                if (!instructorEvaluationFilterList.isEmpty()) {
                    contentDto.setInstructorEvaluationCnt(
                        instructorEvaluationFilterList.getFirst().getCourseEvalCount());
                }
                if (!instructorUserNamesFilterList.isEmpty()) {
                    contentDto.setInstructorUserNames(instructorUserNamesFilterList);
                }
            });
        }

        return pageDto.map(EducationListResponse::new);
    }

    public EducationResponse selectEducation(Long educationSeq) {
        EducationDto dto = educationRepository.selectEducation(educationSeq);
        dto.setEducationInstructorDtos(educationInstructorRepository.selectEducationInstructorList(educationSeq));
        dto.setEducationAttendUserDtos(educationAttendUserRepository.selectEducationAttendUserList(educationSeq));

        List<String> userIdList = new ArrayList<>();
        for (EducationInstructorDto educationInstructor : dto.getEducationInstructorDtos()) {
            userIdList.add(educationInstructor.getUserId());
        }
        for (EducationAttendUserDto educationAttendUser : dto.getEducationAttendUserDtos()) {
            userIdList.add(educationAttendUser.getUserId());
        }

        HrEmpTransDto hrEmpDto = new HrEmpTransDto();
        hrEmpDto.setEmpNoList(userIdList);
        HrWrapperListDto<HrEmpDto> hrDataList = commonFunction.getHrEmps(hrEmpDto);

        for (EducationInstructorDto educationInstructor : dto.getEducationInstructorDtos()) {
            List<HrEmpDto> selectHrEmpDto = hrDataList.getData().stream()
                .filter(hrDataDto -> hrDataDto.getEmpNo().equals(educationInstructor.getUserId())).toList();
            if (!selectHrEmpDto.isEmpty()) {
                educationInstructor.setPostName(selectHrEmpDto.getFirst().getPostNm());
            }
        }

        for (EducationAttendUserDto educationAttendUser : dto.getEducationAttendUserDtos()) {
            HrEmpDto selectHrEmpDto = hrDataList.getData().stream()
                .filter(hrDataDto -> hrDataDto.getEmpNo().equals(educationAttendUser.getUserId())).toList().getFirst();
            educationAttendUser.setPostName(selectHrEmpDto.getPostNm());
        }

        return dto.convertEducationResponse();
    }

    @Transactional
    public Long insertEducationDetail(EducationRequest request) {
        EducationDto dto = new EducationDto(request);
        educationRepository.insertEducation(dto);

        return dto.getEducationSeq();
    }

    @Transactional
    public Long updateEducationDetail(Long educationSeq, EducationRequest request) {
        request.setEducationSeq(educationSeq);
        EducationDto dto = new EducationDto(request);
        educationRepository.updateEducation(dto);
        return educationSeq;
    }

    @Transactional
    public int deleteEducation(Long educationSeq) {
        int deleteResult = 0;

        deleteResult += instructorEvaluationRepository.deleteAllInstructorEvaluation(educationSeq);
        deleteResult += courseSurveyRepository.deleteAllCourseSurvey(educationSeq);

        EducationAttendUserDto educationAttendUserDto = new EducationAttendUserDto();
        educationAttendUserDto.setEducationSeq(educationSeq);
        deleteResult += educationAttendUserRepository.deleteAllEducationAttendUser(educationAttendUserDto);

        deleteResult += instructorSelfEvaluationPaperRepository.deleteAllInstructorSelfEvaluationPaper(educationSeq);
        deleteResult += educationInstructorRepository.deleteAllEducationInstructor(educationSeq);

        deleteResult += educationRepository.deleteEducation(educationSeq);

        return deleteResult;
    }

    @Transactional(noRollbackFor = SlackException.class)
    public int saveEducationInstructors(Long educationSeq, List<EducationInstructorRequest> request) {
        int resultCount = 0;

        List<Long> instructorSeqs = request.stream()
            .map(EducationInstructorRequest::getInstructorSeq)
            .toList();
        List<InstructorDto> instructorInfoList = instructorRepository.selectInstructorDetailList(instructorSeqs);
        List<EducationInstructorRequest> sendSlackList = new ArrayList<>();

        for (EducationInstructorRequest requestData : request) {
            InstructorDto instructorInfo = instructorInfoList.stream()
                .filter(instructorDto -> instructorDto.getInstructorSeq().equals(requestData.getInstructorSeq()))
                .toList().getFirst();

            requestData.setExternalBool(instructorInfo.getDepartmentId() == null);
            requestData.setUserId(instructorInfo.getUserId());
            requestData.setUserName(instructorInfo.getUserName());
            requestData.setDepartmentId(instructorInfo.getDepartmentId());
            requestData.setDepartmentName(instructorInfo.getDepartmentName());
            requestData.setAppointDt(instructorInfo.getAppointDt());
            requestData.setEducationSeq(educationSeq);

            EducationInstructorDto dto = new EducationInstructorDto(requestData);

            if (dto.getEducationInstructorSeq() == null || dto.getEducationInstructorSeq() == 0) {
                resultCount += educationInstructorRepository.insertEducationInstructor(dto);
                if (!dto.isExternalBool()) {
                    sendSlackList.add(requestData);
                }
            } else {
                resultCount += educationInstructorRepository.updateEducationInstructor(dto);
            }
        }

        if (!sendSlackList.isEmpty()) {
            sendInstructorAlert(sendSlackList);
        }

        return resultCount;
    }

    private void sendInstructorAlert(List<EducationInstructorRequest> request) {
        List<String> empNoList = request.stream()
            .filter(req -> req.getUserId() != null && !req.getUserId().contains("ETN"))
            .map(EducationInstructorRequest::getUserId)
            .toList();

        if (!empNoList.isEmpty()) {
            String messageSubject = "안전보건교육 강사 지정 알림";
            String messageContent =
                "안전보건교육 " + request.getFirst().getEducationName() + " 강사로 지정되었습니다. 강사 자기 평가서를 작성해주세요.";

            List<String> deptCdList = new ArrayList<>();
            List<MessageSendMethodEnum> messageSendMethodList = new ArrayList<>();
            messageSendMethodList.add(MessageSendMethodEnum.SLACK);

            SendMessageResponse messageResult = messageSendComponent.sendMessage(
                messageSendMethodList, empNoList, deptCdList, messageSubject, messageContent);

            if (messageResult.getSuccessSendQuantity() < 0) {
                throw new SlackException(ExceptionCode.MESSAGE_API_REQUEST_FAILED);
            }
        }
    }

    @Transactional
    public int delEducationInstructors(List<Long> educationInstructorSeqs) {
        int deleteEducationInstructorResult =
            educationInstructorRepository.deleteEducationInstructor(educationInstructorSeqs);

        int deleteInstructorSelfEvaluationResult =
            instructorSelfEvaluationPaperRepository.deleteInstructorSelfEvaluationPaper(educationInstructorSeqs);

        return deleteEducationInstructorResult + deleteInstructorSelfEvaluationResult;
    }

    @Transactional
    public int insertEducationAttendUsers(Long educationSeq, List<EducationAttendUserRequest> request) {
        int insertResult = 0;
        for (EducationAttendUserRequest requestData : request) {
            requestData.setEducationSeq(educationSeq);
            EducationAttendUserDto dto = new EducationAttendUserDto(requestData);

            insertResult += educationAttendUserRepository.insertEducationAttendUser(dto);
        }
        return insertResult;
    }

    @Transactional
    public int delEducationAttendUsers(List<EducationAttendUserRequest> deleteEducationAttendUsers) {
        int deleteResult = 0;

        for (EducationAttendUserRequest deleteEducationAttendUserData : deleteEducationAttendUsers) {
            EducationAttendUserDto dto = new EducationAttendUserDto(deleteEducationAttendUserData);
            deleteResult += educationAttendUserRepository.deleteEducationAttendUser(dto);
            deleteResult += courseSurveyRepository.deleteCourseSurvey(dto);
            deleteResult += instructorEvaluationRepository.deleteInstructorEvaluation(dto);
        }
        return deleteResult;
    }

    @Transactional
    public int insertInstructorSelfEvaluation(Long educationSeq, SaveInstructorSelfEvaluationPaperRequest request) {
        int resultCount = 0;
        EducationInstructorDto educationInstructorDto =
            new EducationInstructorDto(request.getEducationInstructorSelectData());
        resultCount += educationInstructorRepository.updateEducationInstructor(educationInstructorDto);

        List<InstructorSelfEvaluationPaperDto> insertDtoList = new ArrayList<>();
        for (InstructorSelfEvaluationPaperRequest data : request.getInstructorSelfEvaluationPaperList()) {
            InstructorSelfEvaluationPaperDto dataDto = new InstructorSelfEvaluationPaperDto(educationSeq,
                request.getEducationInstructorSelectData().getEducationInstructorSeq(), data);
            insertDtoList.add(dataDto);
        }

        resultCount += instructorSelfEvaluationPaperRepository.insertInstructorSelfEvaluationPaper(insertDtoList);

        return resultCount;
    }

    @Transactional
    public int updateInstructorSelfEvaluation(Long educationSeq, SaveInstructorSelfEvaluationPaperRequest request) {
        int resultCount = 0;
        EducationInstructorDto educationInstructorDto =
            new EducationInstructorDto(request.getEducationInstructorSelectData());
        resultCount += educationInstructorRepository.updateEducationInstructor(educationInstructorDto);

        for (InstructorSelfEvaluationPaperRequest data : request.getInstructorSelfEvaluationPaperList()) {
            InstructorSelfEvaluationPaperDto dataDto = new InstructorSelfEvaluationPaperDto(educationSeq,
                request.getEducationInstructorSelectData().getEducationInstructorSeq(), data);
            resultCount += instructorSelfEvaluationPaperRepository.updateInstructorSelfEvaluationPaper(dataDto);
        }

        return resultCount;
    }

    public List<InstructorSelfEvaluationPaperResponse> selectInstructorSelfEvaluationPaperAnswer(
        Long educationInstructorSeq) {
        List<InstructorSelfEvaluationPaperDto> selfEvaluationPaperAnswers =
            instructorSelfEvaluationPaperRepository.selectInstructorSelfEvaluationPaperList(educationInstructorSeq);

        List<InstructorSelfEvaluationPaperResponse> selfEvaluationPaperAnswersResponse = new ArrayList<>();
        for (InstructorSelfEvaluationPaperDto selfEvaluationPaperAnswer : selfEvaluationPaperAnswers) {
            InstructorSelfEvaluationPaperResponse selfEvaluationPaperAnswerResponse =
                new InstructorSelfEvaluationPaperResponse(selfEvaluationPaperAnswer);
            selfEvaluationPaperAnswersResponse.add(selfEvaluationPaperAnswerResponse);
        }

        return selfEvaluationPaperAnswersResponse;
    }

    @Transactional
    public int insertCourseSurvey(List<CourseSurveyRequest> requestList) {

        List<CourseSurveyDto> insertDtoList = new ArrayList<>();
        for (CourseSurveyRequest data : requestList) {
            CourseSurveyDto dataDto = new CourseSurveyDto(data);
            insertDtoList.add(dataDto);
        }

        return courseSurveyRepository.insertCourseSurvey(insertDtoList);
    }

    @Transactional
    public Integer updateCourseSurvey(List<CourseSurveyRequest> requestList) {
        int resultCount = 0;

        for (CourseSurveyRequest data : requestList) {
            CourseSurveyDto dataDto = new CourseSurveyDto(data);
            resultCount += courseSurveyRepository.updateCourseSurvey(dataDto);
        }

        return resultCount;
    }

    public List<CourseSurveyResponse> selectCourseSurveyAnswer(Long educationAttendUserSeq) {
        List<CourseSurveyDto> courseSurveyAnswers =
            courseSurveyRepository.selectCourseSurveyList(educationAttendUserSeq);

        List<CourseSurveyResponse> courseSurveyAnswersResponse = new ArrayList<>();
        for (CourseSurveyDto courseSurveyAnswer : courseSurveyAnswers) {
            CourseSurveyResponse courseSurveyAnswerResponse = new CourseSurveyResponse(courseSurveyAnswer);
            courseSurveyAnswersResponse.add(courseSurveyAnswerResponse);
        }

        return courseSurveyAnswersResponse;
    }

    @Transactional
    public int insertInstructorEvaluation(Long educationSeq, SaveInstructorEvaluationRequest request) {

        int resultCount = 0;

        List<InstructorEvaluationDto> insertDtoList = new ArrayList<>();
        for (InstructorEvaluationRequest data : request.getInstructorEvaluationList()) {
            InstructorEvaluationDto dataDto = new InstructorEvaluationDto(educationSeq,
                request.getEducationAttendUserSelectData().getEducationAttendUserSeq(), data);
            insertDtoList.add(dataDto);
        }

        resultCount += instructorEvaluationRepository.insertInstructorEvaluation(insertDtoList);

        return resultCount;

    }

    @Transactional
    public int updateInstructorEvaluation(Long educationSeq, SaveInstructorEvaluationRequest request) {
        int resultCount = 0;

        for (InstructorEvaluationRequest data : request.getInstructorEvaluationList()) {
            InstructorEvaluationDto dataDto = new InstructorEvaluationDto(educationSeq,
                request.getEducationAttendUserSelectData().getEducationAttendUserSeq(), data);
            resultCount += instructorEvaluationRepository.updateInstructorEvaluation(dataDto);
        }

        return resultCount;
    }

    public List<InstructorEvaluationResponse> selectInstructorEvaluationAnswer(
        Long educationSeq, Long educationAttendUserSeq) {
        List<InstructorEvaluationDto> resultList =
            instructorEvaluationRepository.selectInstructorEvaluation(educationSeq, educationAttendUserSeq);

        List<InstructorEvaluationResponse> resultResponseList = new ArrayList<>();
        for (InstructorEvaluationDto data : resultList) {
            InstructorEvaluationResponse dataResponse = new InstructorEvaluationResponse(data);
            resultResponseList.add(dataResponse);
        }
        return resultResponseList;
    }
}
