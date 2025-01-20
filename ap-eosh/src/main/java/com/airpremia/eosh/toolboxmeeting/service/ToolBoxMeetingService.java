package com.airpremia.eosh.toolboxmeeting.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.common.enums.RoleEnum;
import com.airpremia.eosh.common.query.QueryService;
import com.airpremia.eosh.jobplan.dto.JobEmployeeDto;
import com.airpremia.eosh.jobplan.dto.ManageSupervisionEmployeeDto;
import com.airpremia.eosh.jobplan.repository.JobEmployeeRepository;
import com.airpremia.eosh.jobplan.repository.ManageSupervisionEmployeeRepository;
import com.airpremia.eosh.jobplan.request.JobEmployeeRequest;
import com.airpremia.eosh.toolboxmeeting.controller.request.ToolBoxMeetingRequest;
import com.airpremia.eosh.toolboxmeeting.controller.response.ToolBoxMeetingResponse;
import com.airpremia.eosh.toolboxmeeting.dto.ToolBoxMeetingDto;
import com.airpremia.eosh.toolboxmeeting.repository.ToolBoxMeetingRepository;
import com.airpremia.eosh.usertoken.dto.UserTokenDto;
import com.airpremia.eosh.usertoken.service.UserTokenService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ToolBoxMeetingService {

    private final ToolBoxMeetingRepository toolBoxMeetingRepository;
    private final JobEmployeeRepository jobEmployeeRepository;
    private final ManageSupervisionEmployeeRepository manageSupervisionEmployeeRepository;
    private final UserTokenService userTokenService;

    public Page<ToolBoxMeetingResponse> selectToolBoxMeetingPage(
        ToolBoxMeetingRequest toolBoxMeetingSearchRequest, Pageable pageable) {
        ToolBoxMeetingRequest dto = new ToolBoxMeetingRequest();
        QueryService queryService = new QueryService();
        dto.setJobDtStart(toolBoxMeetingSearchRequest.getJobDtStart());
        dto.setJobDtEnd(toolBoxMeetingSearchRequest.getJobDtEnd());

        UserTokenDto userToken = userTokenService.getUserToken();
        List<String> roles = userToken.getRoles();
        dto.setToolBoxMeetingSubject(
            queryService.formatLikeOperator(toolBoxMeetingSearchRequest.getToolBoxMeetingSubject()));
        Page<ToolBoxMeetingDto> pageDto;
        if (isAdminOrSuperAdmin(roles)) {
            pageDto = toolBoxMeetingRepository.selectToolBoxMeetingPage(dto, pageable);
        } else {
            pageDto = toolBoxMeetingRepository.selectToolBoxMeetingPageUser(dto, pageable, userToken.getEmpNo());
        }
        return pageDto.map(ToolBoxMeetingResponse::new);
    }

    private boolean isAdminOrSuperAdmin(List<String> roles) {
        return roles.contains(RoleEnum.ADMIN.getRoleName()) || roles.contains(RoleEnum.SUPER_ADMIN.getRoleName());
    }

    public ToolBoxMeetingResponse selectToolBoxMeeting(Long toolBoxMeetingSeq) {
        UserTokenDto userToken = userTokenService.getUserToken();
        List<String> roles = userToken.getRoles();
        ToolBoxMeetingDto dto = toolBoxMeetingRepository.selectToolBoxMeeting(toolBoxMeetingSeq);
        if (dto == null) {
            dto = new ToolBoxMeetingDto();
        }
        if (isAdminOrSuperAdmin(roles)) {
            dto.setJobEmployeeDtoList(jobEmployeeRepository.selectJobEmployeeList(toolBoxMeetingSeq));
        } else {
            dto.setJobEmployeeDtoList(
                jobEmployeeRepository.selectJobEmployeeListByUser(toolBoxMeetingSeq, userToken.getEmpNo()));
        }
        dto.setManageSupervisionEmployeeDtoList(
            manageSupervisionEmployeeRepository.selectManageSupervisionEmployeeList(toolBoxMeetingSeq));
        return dto.convertToolBoxMeetingResponse();
    }

    public int updateJobEmployeeSignatureTbm(JobEmployeeRequest req) {
        JobEmployeeDto dto = new JobEmployeeDto(req);
        dto.setTbmBool(true);
        return jobEmployeeRepository.updateJobEmployeeSignatureTbm(dto);
    }

    @Transactional
    public int updateToolBoxMeeting(ToolBoxMeetingRequest req) {
        int result = 0;
        ToolBoxMeetingDto dto = new ToolBoxMeetingDto(req);
        if (dto.getToolBoxMeetingSeq() == null) {
            result += insertToolBoxCase(dto, result);
        } else {
            result += updateToolBoxMeetingCase(dto, result);
        }
        return result;
    }

    private int updateToolBoxMeetingCase(ToolBoxMeetingDto dto, int result) {
        List<JobEmployeeDto> jobEmployeeDtoList =
            jobEmployeeRepository.selectJobEmployeeList(dto.getToolBoxMeetingSeq());
        List<JobEmployeeDto> jobEmployeeDeleteList =
            jobEmployeeDtoList.stream()
                .filter(o -> dto.getJobEmployeeDtoList().stream().noneMatch(
                    n -> o.getJobEmployeeSeq().equals(n.getJobEmployeeSeq())))
                .toList();
        for (JobEmployeeDto deleteDto : jobEmployeeDeleteList) {
            jobEmployeeRepository.deleteJobEmployee(deleteDto.getJobEmployeeSeq());
        }

        result += toolBoxMeetingRepository.updateToolBoxMeeting(dto);
        for (JobEmployeeDto jobEmployeeDto : dto.getJobEmployeeDtoList()) {
            if (jobEmployeeDto.getJobEmployeeSeq() == null) {
                jobEmployeeDto.setToolBoxMeetingSeq(dto.getToolBoxMeetingSeq());
                result += jobEmployeeRepository.insertJobEmployee(jobEmployeeDto);
            } else {
                result += jobEmployeeRepository.updateJobEmployee(jobEmployeeDto);
            }
        }

        List<ManageSupervisionEmployeeDto> manageSupervisionEmployeeDtoList =
            manageSupervisionEmployeeRepository.selectManageSupervisionEmployeeList(dto.getToolBoxMeetingSeq());
        List<ManageSupervisionEmployeeDto> manageSupervisionEmployeeDeleteList =
            manageSupervisionEmployeeDtoList.stream()
                .filter(o -> dto.getManageSupervisionEmployeeDtoList().stream().noneMatch(
                    n -> o.getManageSupervisionEmployeeSeq().equals(n.getManageSupervisionEmployeeSeq())))
                .toList();
        for (ManageSupervisionEmployeeDto deleteDto : manageSupervisionEmployeeDeleteList) {
            result += manageSupervisionEmployeeRepository.deleteManageSupervisionEmployee(
                deleteDto.getManageSupervisionEmployeeSeq());
        }

        for (ManageSupervisionEmployeeDto manageSupervisionEmployeeDto :
            dto.getManageSupervisionEmployeeDtoList()) {
            if (manageSupervisionEmployeeDto.getManageSupervisionEmployeeSeq() == null) {
                manageSupervisionEmployeeDto.setToolBoxMeetingSeq(dto.getToolBoxMeetingSeq());
                result +=
                    manageSupervisionEmployeeRepository.insertManageSupervisionEmployee(
                        manageSupervisionEmployeeDto);
            } else {
                result +=
                    manageSupervisionEmployeeRepository.updateManageSupervisionEmployee(
                        manageSupervisionEmployeeDto);
            }
        }
        return result;
    }

    private int insertToolBoxCase(ToolBoxMeetingDto dto, int result) {
        result += toolBoxMeetingRepository.insertToolBoxMeeting(dto);
        for (JobEmployeeDto jobEmployeeDto : dto.getJobEmployeeDtoList()) {
            jobEmployeeDto.setToolBoxMeetingSeq(dto.getToolBoxMeetingSeq());
            if (jobEmployeeDto.getJobEmployeeSeq() == null) {
                result += jobEmployeeRepository.insertJobEmployee(jobEmployeeDto);
            }
        }
        for (ManageSupervisionEmployeeDto manageSupervisionEmployeeDto :
            dto.getManageSupervisionEmployeeDtoList()) {
            manageSupervisionEmployeeDto.setToolBoxMeetingSeq(dto.getToolBoxMeetingSeq());
            if (manageSupervisionEmployeeDto.getManageSupervisionEmployeeSeq() == null) {
                result +=
                    manageSupervisionEmployeeRepository.insertManageSupervisionEmployee(
                        manageSupervisionEmployeeDto);
            }
        }
        return result;
    }

    @Transactional
    public int deleteToolBoxMeeting(Long toolBoxMeetingSeq) {
        int result = 0;
        result += toolBoxMeetingRepository.deleteToolBoxMeeting(toolBoxMeetingSeq);
        result += toolBoxMeetingRepository.deleteJobEmployeeByToolBoxSeq(toolBoxMeetingSeq);
        result += toolBoxMeetingRepository.deleteManageSupervisionEmployeeToolBoxSeq(
            toolBoxMeetingSeq);
        return result;
    }
}
