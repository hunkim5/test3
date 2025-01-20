package com.airpremia.eosh.committee.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.committee.controller.request.CommitteeRequest;
import com.airpremia.eosh.committee.controller.request.MeetingAttendUserRequest;
import com.airpremia.eosh.committee.controller.request.MeetingContractorSafetyHealthRequest;
import com.airpremia.eosh.committee.controller.request.MeetingExternalUserRequest;
import com.airpremia.eosh.committee.controller.request.MeetingResultRequest;
import com.airpremia.eosh.committee.controller.request.MeetingSearchRequest;
import com.airpremia.eosh.committee.controller.response.CommitteeResponse;
import com.airpremia.eosh.committee.controller.response.MeetingAttendUserResponse;
import com.airpremia.eosh.committee.controller.response.MeetingContractorSafetyHealthResponse;
import com.airpremia.eosh.committee.controller.response.MeetingExternalUserResponse;
import com.airpremia.eosh.committee.controller.response.MeetingResponse;
import com.airpremia.eosh.committee.controller.response.MeetingResultResponse;
import com.airpremia.eosh.committee.dto.MeetingAttendUserDto;
import com.airpremia.eosh.committee.dto.MeetingContractorSafetyHealthDto;
import com.airpremia.eosh.committee.dto.MeetingDto;
import com.airpremia.eosh.committee.dto.MeetingResultDto;
import com.airpremia.eosh.committee.dto.MeetingSearchDto;
import com.airpremia.eosh.committee.enums.CommitteeEnum;
import com.airpremia.eosh.committee.repository.MeetingAttendUserRepository;
import com.airpremia.eosh.committee.repository.MeetingContractorSafetyHealthRepository;
import com.airpremia.eosh.committee.repository.MeetingRepository;
import com.airpremia.eosh.committee.repository.MeetingResultRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommitteeService {
    private final MeetingRepository meetingRepository;
    private final MeetingAttendUserRepository meetingAttendUserRepository;
    private final MeetingResultRepository meetingResultRepository;
    private final MeetingContractorSafetyHealthRepository meetingContractorSafetyHealthRepository;

    @Transactional
    public CommitteeResponse insertMeeting(CommitteeRequest saveRequest) {
        MeetingDto meetingDto = new MeetingDto(saveRequest.getMeetingRequest());
        meetingRepository.insertMeeting(meetingDto);
        Long meetingSeq = meetingDto.getMeetingSeq();

        insertMeetingAttendUser(
            saveRequest.getMeetingAttendUserRequestList(), meetingSeq);

        insertMeetingAttendResult(
            saveRequest.getMeetingResultRequestList(), meetingSeq);

        upsertMeetingExternalUserList(
            saveRequest.getMeetingExternalUserRequestList(), meetingSeq);

        return selectCommittee(meetingSeq);
    }

    @Transactional
    public CommitteeResponse updateMeeting(CommitteeRequest saveRequest) {
        Long meetingSeq = saveRequest.getMeetingSeq();
        MeetingDto meetingDto = new MeetingDto(saveRequest.getMeetingRequest());
        meetingRepository.updateMeeting(meetingDto);
        insertMeetingAttendUser(
            saveRequest.getMeetingAttendUserRequestList(), meetingSeq);
        updateMeetingAttendUser(
            saveRequest.getMeetingAttendUserRequestList());

        insertMeetingAttendResult(
            saveRequest.getMeetingResultRequestList(), meetingSeq);
        updateMeetingAttendResult(
            saveRequest.getMeetingResultRequestList());

        upsertMeetingExternalUserList(saveRequest.getMeetingExternalUserRequestList(), meetingSeq);
        deleteMeetingAttendUser(saveRequest.getMeetingAttendUserRequestDeleteList());
        deleteMeetingAttendResult(saveRequest.getMeetingResultRequestDeleteList());
        deleteMeetingExternalUserRequest(saveRequest.getMeetingExternalUserRequestDeleteList());

        return selectCommittee(meetingSeq);
    }

    public void insertMeetingAttendUser(
        List<MeetingAttendUserRequest> meetingAttendUserList,
        Long meetingSeq) {
        meetingAttendUserList.stream()
            .map(MeetingAttendUserDto::new)
            .filter(dto -> dto.getMeetingAttendUserSeq() == null)
            .forEach(dto -> {
                dto.setMeetingSeq(meetingSeq);
                meetingAttendUserRepository.insertMeetingAttendUser(dto);
            });
    }


    public void updateMeetingAttendUser(
        List<MeetingAttendUserRequest> meetingAttendUserList) {
        meetingAttendUserList.stream()
            .map(MeetingAttendUserDto::new)
            .filter(dto -> dto.getMeetingAttendUserSeq() != null)
            .forEach(meetingAttendUserRepository::updateMeetingAttendUser);
    }

    public void insertMeetingAttendResult(
        List<MeetingResultRequest> meetingAttendResultList,
        Long meetingSeq) {

        meetingAttendResultList.stream()
            .map(MeetingResultDto::new)
            .filter(dto -> dto.getMeetingResultSeq() == null)
            .forEach(dto -> {
                dto.setMeetingSeq(meetingSeq);
                meetingResultRepository.insertMeetingResult(dto);
            });
    }

    public void updateMeetingAttendResult(
        List<MeetingResultRequest> meetingAttendResultList) {
        meetingAttendResultList.stream()
            .map(MeetingResultDto::new)
            .filter(dto -> dto.getMeetingResultSeq() != null)
            .forEach(meetingResultRepository::updateMeetingResult);
    }


    public void upsertMeetingExternalUserList(
        List<MeetingExternalUserRequest> meetingExternalUserList,
        Long meetingSeq) {

        for (MeetingExternalUserRequest request : meetingExternalUserList) {
            MeetingAttendUserDto dto = new MeetingAttendUserDto(request);
            MeetingContractorSafetyHealthRequest meetingContractorSafetyHealthRequest =
                request.getMeetingContractorSafetyHealth();

            if (dto.getMeetingAttendUserSeq() != null) {
                meetingAttendUserRepository.updateMeetingAttendUser(dto);
            } else {
                dto.setMeetingSeq(meetingSeq);
                meetingAttendUserRepository.insertMeetingAttendUser(dto);
            }
            if (meetingContractorSafetyHealthRequest != null
                && meetingContractorSafetyHealthRequest.getMeetingAttendUserSeq() != null) {
                meetingContractorSafetyHealthRepository.updateMeetingContractorSafetyHealth(
                    new MeetingContractorSafetyHealthDto(request.getMeetingContractorSafetyHealth()));
            } else if (meetingContractorSafetyHealthRequest != null) {
                MeetingContractorSafetyHealthDto healthDto =
                    new MeetingContractorSafetyHealthDto(request.getMeetingContractorSafetyHealth());
                healthDto.setMeetingAttendUserSeq(dto.getMeetingAttendUserSeq());
                meetingContractorSafetyHealthRepository.insertMeetingContractorSafetyHealth(healthDto);
            }
        }
    }

    public void deleteMeetingAttendUser(
        List<MeetingAttendUserRequest> meetingAttendUserDeleteList) {
        for (MeetingAttendUserRequest request : meetingAttendUserDeleteList) {
            meetingAttendUserRepository.deleteMeetingAttendUser(request.getMeetingAttendUserSeq());
        }
    }

    public void deleteMeetingAttendResult(
        List<MeetingResultRequest> meetingAttendResultDeleteList) {
        for (MeetingResultRequest request : meetingAttendResultDeleteList) {
            MeetingResultDto dto = new MeetingResultDto(request);
            meetingResultRepository.deleteMeetingResult(dto);
        }
    }

    public void deleteMeetingExternalUserRequest(
        List<MeetingExternalUserRequest> meetingExternalUserRequestDeleteList) {
        for (MeetingExternalUserRequest request : meetingExternalUserRequestDeleteList) {
            meetingAttendUserRepository.deleteMeetingAttendUser(request.getMeetingAttendUserSeq());
            meetingContractorSafetyHealthRepository.deleteMeetingContractorSafetyHealth(
                request.getMeetingAttendUserSeq());
        }
    }

    public Page<MeetingResponse> selectMeetingPage(
        MeetingSearchRequest searchRequest, Pageable pageable) {

        MeetingSearchDto searchDto = searchRequest.convertMeetingSearchDto();
        if (searchDto.getMeetingSubject() != null) {
            searchDto.setMeetingSubject('%' + searchDto.getMeetingSubject() + '%');
        }
        if (searchDto.getRepresentativeMeetingUserName() != null) {
            searchDto.setRepresentativeMeetingUserName('%' + searchDto.getRepresentativeMeetingUserName() + '%');
        }
        Page<MeetingDto> pageList =
            meetingRepository.selectMeetingPage(searchDto, pageable);
        return pageList.map(MeetingResponse::new);
    }

    public CommitteeResponse selectCommittee(Long meetingSeq) {

        MeetingResponse meetingResponse = meetingRepository.selectMeeting(meetingSeq).convertMeetingResponse();

        List<MeetingAttendUserResponse> meetingAttendUserList =
            meetingAttendUserRepository.selectMeetingAttendUser(meetingSeq, false).stream()
                .map(MeetingAttendUserResponse::new)
                .toList();

        List<MeetingResultResponse> meetingResultList =
            meetingResultRepository.selectMeetingResult(meetingSeq).stream().map(MeetingResultResponse::new)
                .toList();

        CommitteeResponse res = new CommitteeResponse();
        res.setMeetingSeq(meetingSeq);
        res.setMeetingResponse(meetingResponse);
        res.setMeetingAttendUserResponseList(meetingAttendUserList);
        res.setMeetingResultResponseList(meetingResultList);

        if (meetingResponse.getCommitteeEnum().equals(CommitteeEnum.SAFETY_HEALTH_COUNCIL)) {
            List<MeetingExternalUserResponse> meetingExternalUserList =
                meetingAttendUserRepository.selectMeetingAttendUser(meetingSeq, true).stream()
                    .map(MeetingExternalUserResponse::new)
                    .toList();
            for (MeetingExternalUserResponse dto : meetingExternalUserList) {
                MeetingContractorSafetyHealthDto healthDto =
                    meetingContractorSafetyHealthRepository.selectMeetingContractorSafetyHealth(
                        dto.getMeetingAttendUserSeq());
                if (healthDto != null) {
                    dto.setMeetingContractorSafetyHealth(new MeetingContractorSafetyHealthResponse(healthDto));
                } else {
                    dto.setMeetingContractorSafetyHealth(null);
                }
            }
            res.setMeetingExternalUserRequestList(meetingExternalUserList);
        }

        return res;
    }

    public Integer updateUserCheck(Long meetingAttendUserSeq) {
        MeetingAttendUserDto updateDto = new MeetingAttendUserDto();
        updateDto.setMeetingAttendUserSeq(meetingAttendUserSeq);
        updateDto.setCheckDtm(LocalDateTime.now());

        return meetingAttendUserRepository.updateUserCheck(updateDto);
    }
}
