package com.airpremia.eosh.toolboxmeeting.repository;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.toolboxmeeting.controller.request.ToolBoxMeetingRequest;
import com.airpremia.eosh.toolboxmeeting.dto.ToolBoxMeetingDto;


@Repository
public interface ToolBoxMeetingRepository {

    int insertToolBoxMeeting(ToolBoxMeetingDto insertDto);

    int updateToolBoxMeeting(ToolBoxMeetingDto updateDto);

    int deleteToolBoxMeeting(Long toolBoxMeetingSeq);

    int deleteJobEmployeeByToolBoxSeq(Long toolBoxMeetingSeq);

    int deleteManageSupervisionEmployeeToolBoxSeq(Long toolBoxMeetingSeq);

    Page<ToolBoxMeetingDto> selectToolBoxMeetingPage(
        @Param(value = "searchDto") ToolBoxMeetingRequest dto, Pageable pageable);

    Page<ToolBoxMeetingDto> selectToolBoxMeetingPageUser(
        @Param(value = "searchDto") ToolBoxMeetingRequest dto, Pageable pageable, String employeeNumber);

    ToolBoxMeetingDto selectToolBoxMeeting(Long toolBoxMeetingSeq);
}
