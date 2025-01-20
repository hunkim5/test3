package com.airpremia.eosh.personaldetail.health.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.airpremia.eosh.common.CommonFunction;
import com.airpremia.eosh.common.controller.HrEmpResponse;
import com.airpremia.eosh.common.dto.HrEmpDto;
import com.airpremia.eosh.common.dto.HrEmpTransDto;
import com.airpremia.eosh.common.repository.CommonFunctionRepository;
import com.airpremia.eosh.personaldetail.health.controller.HealthPageResponse;
import com.airpremia.eosh.personaldetail.health.controller.HealthRequest;
import com.airpremia.eosh.personaldetail.health.controller.HealthResponse;
import com.airpremia.eosh.personaldetail.health.controller.HealthSearchRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserWorkStressSurveyInsertUpdateRequest;
import com.airpremia.eosh.personaldetail.health.controller.UserWorkStressSurveyPageResponse;
import com.airpremia.eosh.personaldetail.health.controller.UserWorkStressSurveyResponse;
import com.airpremia.eosh.personaldetail.health.controller.UserWorkStressSurveySearchRequest;
import com.airpremia.eosh.personaldetail.health.controller.WorkStressSurveyReportResponse;
import com.airpremia.eosh.personaldetail.health.dto.HealthPageDto;
import com.airpremia.eosh.personaldetail.health.dto.HealthSaveDto;
import com.airpremia.eosh.personaldetail.health.dto.HealthSearchDto;
import com.airpremia.eosh.personaldetail.health.dto.RealTimePublicNormalExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCerebrocardiovascularExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UserCosmicRadiationExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UserNormalExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UserSpecialExaminationDto;
import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveyAnswerDto;
import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveyDto;
import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveyInsertUpdateDto;
import com.airpremia.eosh.personaldetail.health.dto.UserWorkStressSurveySearchDto;
import com.airpremia.eosh.personaldetail.health.dto.WorkStressSurveyAverageDto;
import com.airpremia.eosh.personaldetail.health.dto.WorkStressSurveyReportDto;
import com.airpremia.eosh.personaldetail.health.dto.WorkStressSurveySubmittedUsersDto;
import com.airpremia.eosh.personaldetail.health.enums.StressSurveyCodeEnum;
import com.airpremia.eosh.personaldetail.health.enums.SurveyStatusEnum;
import com.airpremia.eosh.personaldetail.health.repository.HealthRepository;
import com.airpremia.eosh.personaldetail.health.repository.RealTimePublicNormalExaminationRepository;
import com.airpremia.eosh.personaldetail.health.repository.UserCerebrocardiovascularExaminationRepository;
import com.airpremia.eosh.personaldetail.health.repository.UserCosmicRadiationExaminationRepository;
import com.airpremia.eosh.personaldetail.health.repository.UserSpecialExaminationRepository;
import com.airpremia.eosh.personaldetail.health.repository.WorkStressSurveyRepository;
import com.airpremia.eosh.personaldetail.health.response.HealthDeleteResponse;
import com.airpremia.eosh.usertoken.dto.UserTokenDto;
import com.airpremia.eosh.usertoken.service.UserTokenService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class HealthService {
    private final HealthRepository healthRepository;
    private final WorkStressSurveyRepository workStressSurveyRepository;
    private final UserCerebrocardiovascularExaminationRepository userCerebrocardiovascularExaminationRepository;
    private final UserCosmicRadiationExaminationRepository userCosmicRadiationExaminationRepository;
    private final UserSpecialExaminationRepository userSpecialExaminationRepository;
    private final RealTimePublicNormalExaminationRepository realTimePublicNormalExaminationRepository;
    private final CommonFunction commonFunction;
    private final UserTokenService userTokenService;
    private final CommonFunctionRepository commonFunctionRepository;

    private static final String DATE = "uuuuMMdd";

    private static final double SSC01_QUESTION_NUMBER = 3;
    private static final double SSC02_QUESTION_NUMBER = 8;
    private static final double SSC03_QUESTION_NUMBER = 5;
    private static final double SSC04_QUESTION_NUMBER = 4;
    private static final double SSC05_QUESTION_NUMBER = 6;
    private static final double SSC06_QUESTION_NUMBER = 7;
    private static final double SSC07_QUESTION_NUMBER = 6;
    private static final double SSC08_QUESTION_NUMBER = 4;
    private static final double QUESTION_CODE_NUMBER = 8;
    private static final double MAX_SCORE_PER_QUESTION = 4;

    public Page<HealthPageResponse> selectHealthPage(
        HealthSearchRequest searchRequest, Pageable pageable) {
        HealthSearchDto searchDto = searchRequest.convertHealthDto();
        List<HealthPageDto> pageList = healthRepository.selectHealthPage(searchDto);

        HrEmpTransDto hrEmpDto = new HrEmpTransDto();
        hrEmpDto.setEmpNm(searchDto.getEmpNm());

        List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(hrEmpDto);

        for (HrEmpDto empDto : orgHrList) {
            empDto.setResponseKey(empDto.getEmpNo().substring(1, 7) + DateTimeFormatter.ofPattern(DATE)
                .format(empDto.getBirthYmd()));
        }
        List<HealthPageDto> matchList =
            pageList.stream().filter(o -> orgHrList.stream().anyMatch(n -> o.getUserId().equals(n.getResponseKey())))
                .toList();
        for (HealthPageDto dto : matchList) {
            for (HrEmpDto empDto : orgHrList) {
                if (dto.getUserId().equals(empDto.getResponseKey())) {
                    dto.setHrInfo(dto, empDto);
                }
            }
            UserSpecialExaminationDto userSpecialExaminationDto =
                userSpecialExaminationRepository.selectUserSpecialExaminationInfo(dto);
            dto.setUserSpecialExamination(userSpecialExaminationDto != null);

            UserCosmicRadiationExaminationDto userCosmicRadiationExaminationDto =
                userCosmicRadiationExaminationRepository.selectCosmicRadiationExaminationInfo(dto);
            dto.setUserCosmicRadiationExamination(userCosmicRadiationExaminationDto != null);

            UserCerebrocardiovascularExaminationDto userCerebrocardiovascularExaminationDto =
                userCerebrocardiovascularExaminationRepository.selectCerebrocardiovascularExaminationInfo(dto);
            dto.setUserCerebrocardiovascularExamination(String.valueOf(userCerebrocardiovascularExaminationDto));

            WorkStressSurveyReportDto workStressSurveyReportDto =
                workStressSurveyRepository.selectWorkStressSurveyScore(dto);
            if (workStressSurveyReportDto != null) {
                dto.setScore(workStressSurveyReportDto.getScore());
            }
        }
        commonFunction.getPage(matchList, pageable.getPageNumber(), pageable.getPageSize());
        return new PageImpl<>(matchList.stream().map(HealthPageResponse::new).toList());
    }

    private int reverseScore(int score) {
        return switch (score) {
            case 1 -> 4;
            case 2 -> 3;
            case 3 -> 2;
            case 4 -> 1;
            default -> score;
        };
    }

    public List<UserWorkStressSurveyResponse> selectUserWorkStressSurvey(String standardYyyy) {
        UserTokenDto userToken = userTokenService.getUserToken();
        long userSeq = workStressSurveyRepository.selectWorkStressSurveyUserSeq(
            userToken.getEmpNo().substring(1) + DateTimeFormatter.ofPattern(DATE)
                .format(userToken.getBirthYmd()));

        List<UserWorkStressSurveyResponse> resonseList =
            workStressSurveyRepository.selectUserWorkStressSurvey(userSeq, standardYyyy).stream()
                .map(UserWorkStressSurveyResponse::new).toList();

        for (UserWorkStressSurveyResponse resp : resonseList) {
            if (resp.getQuestionCode().contains("_DESC")) {
                resp.setScore(reverseScore(resp.getScore()));
            }
        }

        return resonseList;
    }

    public HealthResponse selectHealth(Long userSeq, String standardYyyy) {
        HealthResponse res = new HealthResponse();

        UserNormalExaminationDto userNormalExaminationDto =
            healthRepository.selectUserNormalExamination(userSeq, standardYyyy);
        if (userNormalExaminationDto != null) {
            res.setUserNormalExaminationResponse(userNormalExaminationDto.convertUserNormalExaminationResponse());
            String userId = userNormalExaminationDto.getUserId();
            String empNo = userId.substring(0, 6);
            String birthDay = userId.substring(8);
            HrEmpResponse hrEmpDto = commonFunction.getHrEmpResponse(empNo);

            String birthDtName = "";
            if (hrEmpDto != null) {
                res.setHrEmpResponse(hrEmpDto);
                birthDtName = birthDay + hrEmpDto.getEmpNm();
            }

            RealTimePublicNormalExaminationDto realTimePublicNormalExaminationDto =
                realTimePublicNormalExaminationRepository.selectRealTimePublicNormalExamination(birthDtName);
            if (realTimePublicNormalExaminationDto != null) {
                res.setRealTimePublicNormalExaminationResponse(
                    realTimePublicNormalExaminationDto.convertRealTimePublicNormalExaminationResponse());
            }

            UserSpecialExaminationDto userSpecialExamination =
                userSpecialExaminationRepository.selectUserSpecialExamination(userSeq, standardYyyy);
            if (userSpecialExamination != null) {
                res.setUserSpecialExaminationResponse(userSpecialExamination.convertUserSpecialExaminationResponse());
            }

            UserCosmicRadiationExaminationDto userCosmicRadiationExamination =
                userCosmicRadiationExaminationRepository.selectUserCosmicRadiationExamination(userSeq, standardYyyy);
            if (userCosmicRadiationExamination != null) {
                res.setUserCosmicRadiationExaminationResponse(
                    userCosmicRadiationExamination.convertUserCosmicRadiationExaminationResponse());
            }


            UserCerebrocardiovascularExaminationDto userCerebrocardiovascularExamination =
                userCerebrocardiovascularExaminationRepository.selectUserCerebrocardiovascularExamination(userSeq,
                    standardYyyy);
            if (userCerebrocardiovascularExamination != null) {
                res.setUserCerebrocardiovascularExaminationResponse(
                    userCerebrocardiovascularExamination.convertUserCerebrocardiovascularExaminationResponse());
            }

            WorkStressSurveyReportDto dto = new WorkStressSurveyReportDto();
            dto.setUserId(userId);
            dto.setStandardYyyy(String.valueOf(LocalDate.now().getYear()));
            List<WorkStressSurveyReportDto> workStressSurveyMaleReportList =
                workStressSurveyRepository.selectUserStressSurveyResult(dto);

            res.setStressScore(getFormulaScore(workStressSurveyMaleReportList).getLast().getFormulaScore());
        }

        return res;
    }

    @Transactional
    public int saveHealth(HealthRequest request) {
        HealthSaveDto dto = new HealthSaveDto(request);

        int result = 0;
        if (dto.getUserNormalSeq() != 0) {
            result += healthRepository.updateUserNormalExamination(dto.getUserNormalExaminationDto());
        } else if (dto.getUserNormalExaminationDto().getExaminationDt() != null) {
            result += healthRepository.insertUserNormalExamination(dto.getUserNormalExaminationDto());
        }
        if (dto.getUserSpecialSeq() != 0) {
            result += userSpecialExaminationRepository.updateUserSpecialExamination(dto.getUserSpecialExaminationDto());
        } else if (dto.getUserSpecialExaminationDto().getExaminationDt() != null) {
            result += userSpecialExaminationRepository.insertUserSpecialExamination(
                dto.getUserSpecialExaminationDto());
        }
        if (dto.getUserCosmicSeq() != 0) {
            result += userCosmicRadiationExaminationRepository.updateUserCosmicRadiationExamination(
                dto.getUserCosmicRadiationExaminationDto());
        } else if (dto.getUserCosmicRadiationExaminationDto().getExaminationDt() != null) {
            result += userCosmicRadiationExaminationRepository.insertUserCosmicRadiationExamination(
                dto.getUserCosmicRadiationExaminationDto());

        }
        if (dto.getUserCerebrovascularSeq() != 0) {
            result += userCerebrocardiovascularExaminationRepository.updateUserCerebrocardiovascularExamination(
                dto.getUserCerebrocardiovascularExaminationDto());
        } else if (dto.getUserCerebrocardiovascularExaminationDto().getExaminationDt() != null) {
            result += userCerebrocardiovascularExaminationRepository.insertUserCerebrocardiovascularExamination(
                dto.getUserCerebrocardiovascularExaminationDto());
        }
        return result;
    }

    @Transactional
    public HealthDeleteResponse deleteHealth(Long userSeq, String standardYyyy) {
        return new HealthDeleteResponse(
            healthRepository.deleteUserNormalExamination(userSeq, standardYyyy),
            userSpecialExaminationRepository.deleteUserSpecialExamination(userSeq, standardYyyy),
            userCosmicRadiationExaminationRepository.deleteUserCosmicRadiationExamination(userSeq, standardYyyy),
            userCerebrocardiovascularExaminationRepository.deleteUserCerebrocardiovascularExamination(userSeq,
                standardYyyy)
        );
    }

    public Page<UserWorkStressSurveyPageResponse> selectUserWorkStressSurveyPage(
        UserWorkStressSurveySearchRequest searchRequest, Pageable pageable) {
        UserWorkStressSurveySearchDto searchDto = searchRequest.convertUserWorkStressSurveySearchDto();

        List<UserWorkStressSurveyPageResponse> list =
            workStressSurveyRepository.selectUserWorkStressSurveyPage(searchDto, pageable);

        for (UserWorkStressSurveyPageResponse data : list) {
            String empNo = "P" + data.getUserId().substring(0, 6);
            data.setEmpNo(empNo);
        }

        HrEmpTransDto hrEmpDto = new HrEmpTransDto();
        hrEmpDto.setSearchValue(searchDto);

        List<HrEmpDto> orgHrList = commonFunction.getHrEmpsLiveList(hrEmpDto);
        List<UserWorkStressSurveyPageResponse> matchList =
            list.stream().filter(o -> orgHrList.stream().anyMatch(n -> o.getEmpNo().equals(n.getEmpNo())))
                .toList();

        for (UserWorkStressSurveyPageResponse dto : matchList) {
            for (HrEmpDto empDto : orgHrList) {
                if (dto.getEmpNo().equals(empDto.getEmpNo())) {
                    dto.mergeInfo(dto, empDto);
                }
            }
        }

        int total = matchList.size();
        matchList = commonFunction.getPage(matchList, pageable.getPageNumber(), pageable.getPageSize());

        return new PageImpl<>(matchList.stream().map(UserWorkStressSurveyPageResponse::new).toList(), pageable, total);
    }

    @Transactional
    public int saveUserWorkStressSurvey(UserWorkStressSurveyInsertUpdateRequest request) {
        UserTokenDto userToken = userTokenService.getUserToken();

        if (request.getSex() == null) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "설문 저장에 실패했습니다. 다시 시도해주세요.");
        }

        UserWorkStressSurveyInsertUpdateDto reqDto = new UserWorkStressSurveyInsertUpdateDto(request);
        reqDto.setUserId(userToken.getEmpNo());

        long userSeq = workStressSurveyRepository.selectWorkStressSurveyUserSeq(
            userToken.getEmpNo().substring(1) + DateTimeFormatter.ofPattern(DATE)
                .format(userToken.getBirthYmd()));
        reqDto.setUserSeq(userSeq);

        int result = 0;
        int cnt = 0;
        int updateUserSexResult = 0;

        for (UserWorkStressSurveyAnswerDto answerDto : reqDto.getUserWorkStressSurveyAnswerDtoList()) {
            answerDto.setInsertUserId(reqDto.getUserId());
            answerDto.setStandardYyyy(reqDto.getStandardYyyy());
            answerDto.setUserSeq(userSeq);

            if (answerDto.getQuestionCode().contains("_DESC")) {
                answerDto.setScore(reverseScore(answerDto.getScore()));
            }

            cnt = workStressSurveyRepository.checkUserWorkStressSurveyAnswerSave(answerDto);
            if (cnt == 0) {
                result += workStressSurveyRepository.insertUserWorkStressSurveyAnswer(answerDto);
            } else {
                result += workStressSurveyRepository.updateUserWorkStressSurveyAnswer(answerDto);
            }
        }

        if (reqDto.getSurveyStatus() == SurveyStatusEnum.SUBMIT) {
            WorkStressSurveyReportDto reportDto = new WorkStressSurveyReportDto();
            reportDto.setUserSeq(userSeq);
            reportDto.setStandardYyyy(reqDto.getStandardYyyy());
            List<WorkStressSurveyReportDto> data =
                workStressSurveyRepository.selectUserStressSurveyResult(reportDto);
            List<WorkStressSurveyReportDto> stressSurveyResultList = getFormulaScore(data);
            double averageScore = stressSurveyResultList.getLast().getFormulaScore();
            reqDto.setAverageScore(averageScore);
        }

        if (cnt == 0) {
            result += workStressSurveyRepository.insertUserWorkStressSurvey(reqDto);
        } else {
            result += workStressSurveyRepository.updateUserWorkStressSurvey(reqDto);
        }

        updateUserSexResult += workStressSurveyRepository.updateUserSex(reqDto);
        if (updateUserSexResult != 1) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "설문 저장에 실패했습니다. 다시 시도해주세요.");
        }

        return result;
    }

    private List<WorkStressSurveyReportDto> getFormulaScore(List<WorkStressSurveyReportDto> list) {
        double totalFormulaScore = 0;

        for (WorkStressSurveyReportDto answerDto : list) {
            StressSurveyCodeEnum evaluationItemCode = answerDto.getEvaluationItemCode();
            int score = answerDto.getScore();
            double formulaScore;

            if (evaluationItemCode == StressSurveyCodeEnum.SSC01) {
                formulaScore = calculateScore(score, SSC01_QUESTION_NUMBER);
                answerDto.setFormulaScore(formulaScore);
                totalFormulaScore += formulaScore;
            } else if (evaluationItemCode == StressSurveyCodeEnum.SSC02) {
                formulaScore = calculateScore(score, SSC02_QUESTION_NUMBER);
                answerDto.setFormulaScore(formulaScore);
                totalFormulaScore += formulaScore;
            } else if (evaluationItemCode == StressSurveyCodeEnum.SSC03) {
                formulaScore = calculateScore(score, SSC03_QUESTION_NUMBER);
                answerDto.setFormulaScore(formulaScore);
                totalFormulaScore += formulaScore;
            } else if (evaluationItemCode == StressSurveyCodeEnum.SSC04) {
                formulaScore = calculateScore(score, SSC04_QUESTION_NUMBER);
                answerDto.setFormulaScore(formulaScore);
                totalFormulaScore += formulaScore;
            } else if (evaluationItemCode == StressSurveyCodeEnum.SSC05) {
                formulaScore = calculateScore(score, SSC05_QUESTION_NUMBER);
                answerDto.setFormulaScore(formulaScore);
                totalFormulaScore += formulaScore;
            } else if (evaluationItemCode == StressSurveyCodeEnum.SSC06) {
                formulaScore = calculateScore(score, SSC06_QUESTION_NUMBER);
                answerDto.setFormulaScore(formulaScore);
                totalFormulaScore += formulaScore;
            } else if (evaluationItemCode == StressSurveyCodeEnum.SSC07) {
                formulaScore = calculateScore(score, SSC07_QUESTION_NUMBER);
                answerDto.setFormulaScore(formulaScore);
                totalFormulaScore += formulaScore;
            } else if (evaluationItemCode == StressSurveyCodeEnum.SSC08) {
                formulaScore = calculateScore(score, SSC08_QUESTION_NUMBER);
                answerDto.setFormulaScore(formulaScore);
                totalFormulaScore += formulaScore;
            }
        }

        totalFormulaScore = Math.floor(totalFormulaScore / QUESTION_CODE_NUMBER * 10) / 10;
        WorkStressSurveyReportDto totalFormulaDto = new WorkStressSurveyReportDto();
        totalFormulaDto.setEvaluationItemCode(StressSurveyCodeEnum.SSC_TOTAL);
        totalFormulaDto.setFormulaScore(totalFormulaScore);
        list.add(totalFormulaDto);
        return list;
    }

    /*
     * 항목별 계산 참고자료 (sharepoint)
     * 문서 > 90. 현업자료 > eSMS-산업안전보건 > 서식 > 직무스트레스평가 분석(기본형-엑셀).xls
     * 문서 > 03. 설계 > 02. 화면설계 > 03) 산업안전 > SPT2024-AP-40130_화면설계서_산업안전_V1.185.pptx
     * > '건강검진>직무스트레스설문(p.183~187)', '건강관리(p.195~198)'
     * */
    private double calculateScore(int score, double questionNumber) {
        double formulaScore = (score - questionNumber) * 100 / (questionNumber * MAX_SCORE_PER_QUESTION
                                                                - questionNumber);
        return Math.floor(formulaScore * 10) / 10;
    }

    private List<WorkStressSurveyReportDto> calculateStressAverageScore(
        List<WorkStressSurveyReportDto> stressSurveyResultList,
        UserWorkStressSurveySearchRequest req,
        boolean isDept) {

        WorkStressSurveyAverageDto averageDto = new WorkStressSurveyAverageDto();
        double totalSsc01 = 0;
        double totalSsc02 = 0;
        double totalSsc03 = 0;
        double totalSsc04 = 0;
        double totalSsc05 = 0;
        double totalSsc06 = 0;
        double totalSsc07 = 0;
        double totalSsc08 = 0;
        double sscTotal = 0;

        List<WorkStressSurveySubmittedUsersDto> submittedList = isDept
            ? workStressSurveyRepository.selectSurveySubmittedDeptUsers(req.getStandardYyyy(), req.getDeptCd())
            : workStressSurveyRepository.selectSurveySubmittedUsers(req.getStandardYyyy());

        if (submittedList == null || submittedList.isEmpty()) {
            return Collections.emptyList();
        }

        for (WorkStressSurveySubmittedUsersDto submittedUser : submittedList) {
            sscTotal += submittedUser.getAverageScore();

            WorkStressSurveyReportDto dto = new WorkStressSurveyReportDto();
            dto.setUserSeq(submittedUser.getUserSeq());
            dto.setStandardYyyy(submittedUser.getStandardYyyy());

            List<WorkStressSurveyReportDto> submittedUserAnswer =
                workStressSurveyRepository.selectUserStressSurveyResult(dto);
            List<WorkStressSurveyReportDto> submittedUserFormulaAnswer = getFormulaScore(submittedUserAnswer);

            for (WorkStressSurveyReportDto formulaAnswerData : submittedUserFormulaAnswer) {
                switch (formulaAnswerData.getEvaluationItemCode()) {
                    case SSC01 -> totalSsc01 += formulaAnswerData.getFormulaScore();
                    case SSC02 -> totalSsc02 += formulaAnswerData.getFormulaScore();
                    case SSC03 -> totalSsc03 += formulaAnswerData.getFormulaScore();
                    case SSC04 -> totalSsc04 += formulaAnswerData.getFormulaScore();
                    case SSC05 -> totalSsc05 += formulaAnswerData.getFormulaScore();
                    case SSC06 -> totalSsc06 += formulaAnswerData.getFormulaScore();
                    case SSC07 -> totalSsc07 += formulaAnswerData.getFormulaScore();
                    case SSC08 -> totalSsc08 += formulaAnswerData.getFormulaScore();
                    case SSC_TOTAL -> sscTotal += 0;
                    default -> throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,
                        "새로운 설문 항목 코드를 발견했습니다. 계산식을 추가해주세요.");
                }
            }
        }

        int size = submittedList.size();
        averageDto.setAverageSsc01(Math.floor(totalSsc01 / size * 10) / 10);
        averageDto.setAverageSsc02(Math.floor(totalSsc02 / size * 10) / 10);
        averageDto.setAverageSsc03(Math.floor(totalSsc03 / size * 10) / 10);
        averageDto.setAverageSsc04(Math.floor(totalSsc04 / size * 10) / 10);
        averageDto.setAverageSsc05(Math.floor(totalSsc05 / size * 10) / 10);
        averageDto.setAverageSsc06(Math.floor(totalSsc06 / size * 10) / 10);
        averageDto.setAverageSsc07(Math.floor(totalSsc07 / size * 10) / 10);
        averageDto.setAverageSsc08(Math.floor(totalSsc08 / size * 10) / 10);
        averageDto.setSscTotalAverage(Math.floor(sscTotal / size * 10) / 10);

        List<WorkStressSurveyReportDto> resultList;

        if (isDept) {
            resultList = setDeptStressAverageScore(averageDto, stressSurveyResultList);
        } else {
            resultList = setCompanyStressAverageScore(averageDto, stressSurveyResultList);
        }

        return resultList;
    }

    private List<WorkStressSurveyReportDto> setCompanyStressAverageScore(
        WorkStressSurveyAverageDto averageDto, List<WorkStressSurveyReportDto> stressSurveyResultList) {

        for (WorkStressSurveyReportDto resultDto : stressSurveyResultList) {
            if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC01) {
                resultDto.setCompanyAverageScore(averageDto.getAverageSsc01());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC02) {
                resultDto.setCompanyAverageScore(averageDto.getAverageSsc02());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC03) {
                resultDto.setCompanyAverageScore(averageDto.getAverageSsc03());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC04) {
                resultDto.setCompanyAverageScore(averageDto.getAverageSsc04());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC05) {
                resultDto.setCompanyAverageScore(averageDto.getAverageSsc05());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC06) {
                resultDto.setCompanyAverageScore(averageDto.getAverageSsc06());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC07) {
                resultDto.setCompanyAverageScore(averageDto.getAverageSsc07());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC08) {
                resultDto.setCompanyAverageScore(averageDto.getAverageSsc08());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC_TOTAL) {
                resultDto.setCompanyAverageScore(averageDto.getSscTotalAverage());
            }
        }

        return stressSurveyResultList;
    }

    private List<WorkStressSurveyReportDto> setDeptStressAverageScore(
        WorkStressSurveyAverageDto averageDto, List<WorkStressSurveyReportDto> stressSurveyResultList) {

        for (WorkStressSurveyReportDto resultDto : stressSurveyResultList) {
            if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC01) {
                resultDto.setDeptAverageScore(averageDto.getAverageSsc01());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC02) {
                resultDto.setDeptAverageScore(averageDto.getAverageSsc02());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC03) {
                resultDto.setDeptAverageScore(averageDto.getAverageSsc03());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC04) {
                resultDto.setDeptAverageScore(averageDto.getAverageSsc04());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC05) {
                resultDto.setDeptAverageScore(averageDto.getAverageSsc05());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC06) {
                resultDto.setDeptAverageScore(averageDto.getAverageSsc06());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC07) {
                resultDto.setDeptAverageScore(averageDto.getAverageSsc07());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC08) {
                resultDto.setDeptAverageScore(averageDto.getAverageSsc08());
            } else if (resultDto.getEvaluationItemCode() == StressSurveyCodeEnum.SSC_TOTAL) {
                resultDto.setDeptAverageScore(averageDto.getSscTotalAverage());
            }
        }

        return stressSurveyResultList;
    }

    public List<WorkStressSurveyReportResponse> selectUserStressSurveyResult(UserWorkStressSurveySearchRequest req) {
        WorkStressSurveyReportDto dto = new WorkStressSurveyReportDto();
        dto.setUserSeq(req.getUserSeq());
        dto.setStandardYyyy(req.getStandardYyyy());
        List<WorkStressSurveyReportDto> data =
            workStressSurveyRepository.selectUserStressSurveyResult(dto);
        List<WorkStressSurveyReportDto> stressSurveyResultList = getFormulaScore(data);

        List<WorkStressSurveyReportDto> resultList =
            calculateStressAverageScore(stressSurveyResultList, req, false);

        if (req.getDeptCd() != null) {
            List<WorkStressSurveyReportDto> deptResultList =
                calculateStressAverageScore(stressSurveyResultList, req, true);

            for (WorkStressSurveyReportDto companyScoreDto : resultList) {
                for (WorkStressSurveyReportDto deptScoreDto : deptResultList) {
                    if (companyScoreDto.getEvaluationItemCode() == deptScoreDto.getEvaluationItemCode()) {
                        companyScoreDto.setDeptAverageScore(deptScoreDto.getDeptAverageScore());
                    }
                }
            }
        }

        return resultList.stream().map(WorkStressSurveyReportResponse::new).toList();
    }

    public HealthResponse getUserSeq(String userId) {
        if (userId == null || userId.trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "유효하지 않은 userId.");
        }
        long userSeq = commonFunctionRepository.selectUserSeq(userId);
        HealthResponse response = new HealthResponse();
        response.setUserSeq(userSeq);
        return response;
    }

    public Boolean checkSurveyStatus(String standardYyyy) {
        UserTokenDto userToken = userTokenService.getUserToken();
        long userSeq = workStressSurveyRepository.selectWorkStressSurveyUserSeq(
            userToken.getEmpNo().substring(1) + DateTimeFormatter.ofPattern(DATE)
                .format(userToken.getBirthYmd()));

        UserWorkStressSurveyDto dto = new UserWorkStressSurveyDto();
        dto.setStandardYyyy(standardYyyy);
        dto.setUserSeq(userSeq);

        SurveyStatusEnum status = workStressSurveyRepository.checkSurveyStatus(dto);
        return status == SurveyStatusEnum.SUBMIT;
    }

}
