package com.airpremia.eosh.committee.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.committee.dto.MeetingResultDto;


@Repository
public interface MeetingResultRepository {

    int insertMeetingResult(MeetingResultDto insertDto);

    int updateMeetingResult(MeetingResultDto updateDto);

    List<MeetingResultDto> selectMeetingResult(Long meetingResultSeq);

    int deleteMeetingResult(MeetingResultDto deleteDto);
}
