package com.airpremia.eosh.education.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.education.controller.EducationAttendUserResponse;
import com.airpremia.eosh.education.controller.EducationInstructorResponse;
import com.airpremia.eosh.education.controller.EducationRequest;
import com.airpremia.eosh.education.controller.EducationResponse;
import com.airpremia.eosh.education.controller.EducationSearchRequest;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EducationDto {

    private Long educationSeq;
    private String educationClassificationCode;
    private LocalDate educationDt;
    private LocalDate educationDtStart;
    private LocalDate educationDtEnd;
    private String inChargeCode;
    private String educationData;
    private String educationContent;
    private String multipleFileUuid;
    private boolean deleteBool;
    private String deleteUserId;
    private LocalDateTime deleteDtm;
    private String deleteIp;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;
    private int courseSurveyCnt;
    private int instructorEvaluationCnt;
    private String userId;

    private List<EducationInstructorDto> educationInstructorDtos;
    private List<EducationAttendUserDto> educationAttendUserDtos;

    public EducationDto(EducationRequest req) {
        this.educationSeq = req.getEducationSeq();
        this.educationClassificationCode = req.getEducationClassificationCode();
        this.educationDt = req.getEducationDt();
        this.inChargeCode = req.getInChargeCode();
        this.educationData = req.getEducationData();
        this.educationContent = req.getEducationContent();
        this.multipleFileUuid = req.getMultipleFileUuid();
        this.deleteBool = req.isDeleteBool();
        this.deleteUserId = req.getDeleteUserId();
        this.deleteDtm = req.getDeleteDtm();
        this.deleteIp = req.getDeleteIp();
        this.insertUserId = req.getInsertUserId();
        this.insertDtm = req.getInsertDtm();
        this.insertIp = req.getInsertIp();
        this.updateUserId = req.getUpdateUserId();
        this.updateDtm = req.getUpdateDtm();
        this.updateIp = req.getUpdateIp();
        if (req.getEducationInstructorRequest() != null) {
            this.educationInstructorDtos =
                req.getEducationInstructorRequest().stream().map(EducationInstructorDto::new).toList();
        }
        if (req.getEducationAttendUserRequest() != null) {
            this.educationAttendUserDtos =
                req.getEducationAttendUserRequest().stream().map(EducationAttendUserDto::new).toList();
        }
    }

    public EducationDto(EducationSearchRequest req) {
        this.educationClassificationCode = req.getEducationClassificationCode();
        this.educationDtStart = req.getEducationDtStart();
        this.educationDtEnd = req.getEducationDtEnd();
        this.inChargeCode = req.getInChargeCode();
        this.userId = req.getUserId();
    }

    public EducationResponse convertEducationResponse() {
        EducationResponse data = new EducationResponse();
        data.setEducationInstructorResponses(
            this.educationInstructorDtos.stream().map(EducationInstructorResponse::new).toList());
        data.setEducationAttendUserResponses(
            this.educationAttendUserDtos.stream().map(EducationAttendUserResponse::new).toList());
        data.setEducationSeq(this.educationSeq);
        data.setEducationClassificationCode(this.educationClassificationCode);
        data.setEducationDt(this.educationDt);
        data.setInChargeCode(this.inChargeCode);
        data.setEducationData(this.educationData);
        data.setEducationContent(this.educationContent);
        data.setMultipleFileUuid(this.multipleFileUuid);
        data.setDeleteBool(this.deleteBool);
        data.setDeleteUserId(this.deleteUserId);
        data.setDeleteDtm(this.deleteDtm);
        data.setDeleteIp(this.deleteIp);
        data.setInsertUserId(this.insertUserId);
        data.setInsertDtm(this.insertDtm);
        data.setInsertIp(this.insertIp);
        data.setUpdateUserId(this.updateUserId);
        data.setUpdateDtm(this.updateDtm);
        data.setUpdateIp(this.updateIp);
        return data;
    }
}

