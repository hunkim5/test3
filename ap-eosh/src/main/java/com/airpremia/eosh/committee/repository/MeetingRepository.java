package com.airpremia.eosh.committee.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.committee.dto.MeetingDto;
import com.airpremia.eosh.committee.dto.MeetingSearchDto;


@Repository
public interface MeetingRepository {

    int insertMeeting(MeetingDto insertDto);

    int updateMeeting(MeetingDto updateDto);

    MeetingDto selectMeeting(Long meetingSeq);

    Page<MeetingDto> selectMeetingPage(@Param(value = "searchDto") MeetingSearchDto data, Pageable pageable);

}
