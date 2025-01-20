package com.airpremia.eosh.jobplan.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.airpremia.eosh.jobplan.enums.JobClassificationCodeEnum;
import com.airpremia.eosh.jobplan.enums.JobPlanPerformEnum;
import com.airpremia.eosh.jobplan.request.JobPlanRequest;
import com.airpremia.eosh.jobplan.request.JobPlanSearchRequest;
import com.airpremia.eosh.jobplan.response.JobPlanResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class JobPlanDto {
    private Long jobSeq;
    private Long toolBoxMeetingSeq;
    private Long checklistSeq;
    private JobClassificationCodeEnum jobClassificationEnum;
    private String jobSubject;
    private LocalDate jobStartDt;
    private LocalDate jobEndDt;
    private String jobContent;
    private String workEquipmentContent;
    private JobPlanPerformEnum jobPlanPerformEnum;
    private String inchargeUserId;
    private String inchargeUserName;
    private String inchargeDepartmentId;
    private String inchargeDepartmentName;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public JobPlanDto(JobPlanRequest req) {
        this.jobSeq = req.getJobSeq();
        this.jobClassificationEnum = req.getJobClassificationEnum();
        this.jobSubject = req.getJobSubject();
        this.jobStartDt = req.getJobStartDt();
        this.jobEndDt = req.getJobEndDt();
        this.jobContent = req.getJobContent();
        this.workEquipmentContent = req.getWorkEquipmentContent();
        this.jobPlanPerformEnum = req.getJobPlanPerformEnum();
        this.inchargeUserId = req.getInchargeUserId();
        this.inchargeUserName = req.getInchargeUserName();
        this.inchargeDepartmentId = req.getInchargeDepartmentId();
        this.inchargeDepartmentName = req.getInchargeDepartmentName();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
    }

    public JobPlanDto(JobPlanSearchRequest req) {
        this.jobClassificationEnum = req.getJobClassificationEnum();
        this.jobSubject = req.getJobSubject() != null ?
            String.format("%%%s%%", req.getJobSubject()) : null;
        this.jobStartDt = req.getJobStartDt();
        this.jobEndDt = req.getJobEndDt();
        this.jobContent = req.getJobContent();
        this.jobPlanPerformEnum = req.getJobPlanPerformEnum();
        this.inchargeUserId = req.getInchargeUserId();
        this.inchargeUserName = req.getInchargeUserName();
        this.inchargeDepartmentId = req.getInchargeDepartmentId();
        this.inchargeDepartmentName = req.getInchargeDepartmentName();
    }

    public JobPlanResponse convertJobPlanResponse() {
        JobPlanResponse data = new JobPlanResponse();
        data.setJobSeq(this.jobSeq);
        data.setChecklistSeq(this.checklistSeq);
        data.setJobClassificationEnum(this.jobClassificationEnum);
        data.setJobSubject(this.jobSubject);
        data.setJobStartDt(this.jobStartDt);
        data.setJobEndDt(this.jobEndDt);
        data.setJobContent(this.jobContent);
        data.setWorkEquipmentContent(this.workEquipmentContent);
        data.setJobPlanPerformEnum(this.jobPlanPerformEnum);
        data.setInchargeUserId(this.inchargeUserId);
        data.setInchargeUserName(this.inchargeUserName);
        data.setInchargeDepartmentId(this.inchargeDepartmentId);
        data.setInchargeDepartmentName(this.inchargeDepartmentName);
        data.setInsertUserId(this.insertUserId);
        data.setInsertDtm(this.insertDtm);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateDtm(this.updateDtm);
        data.setUpdateIp(this.updateIp);
        return data;
    }
}
