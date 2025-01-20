package com.airpremia.eosh.committee.repository;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.committee.dto.MeetingContractorSafetyHealthDto;


@Repository
public interface MeetingContractorSafetyHealthRepository {
    MeetingContractorSafetyHealthDto selectMeetingContractorSafetyHealth(Long meetingAttendUserSeq);

    int insertMeetingContractorSafetyHealth(MeetingContractorSafetyHealthDto insertDto);

    int updateMeetingContractorSafetyHealth(MeetingContractorSafetyHealthDto updateDto);

    int deleteMeetingContractorSafetyHealth(Long meetingAttendUserSeq);
}
