package com.airpremia.eosh.committee.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.committee.dto.MeetingAttendUserDto;


@Repository
public interface MeetingAttendUserRepository {

    int insertMeetingAttendUser(MeetingAttendUserDto insertDto);

    int updateMeetingAttendUser(MeetingAttendUserDto updateDto);

    List<MeetingAttendUserDto> selectMeetingAttendUser(
        @Param(value = "meetingSeq") Long meetingSeq, @Param(value = "externalBool") boolean externalBool);

    int deleteMeetingAttendUser(Long meetingAttendUserSeq);

    int updateUserCheck(MeetingAttendUserDto updateDto);
}
