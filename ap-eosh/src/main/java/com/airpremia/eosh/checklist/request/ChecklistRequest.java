package com.airpremia.eosh.checklist.request;

import java.time.LocalDate;
import java.util.List;

import com.airpremia.eosh.checklist.enums.ChecklistPerformEnum;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ChecklistRequest {

    @Schema(description = "점검표 시퀀스")
    private Long checklistSeq;
    @Schema(description = "작업 시퀀스")
    private Long jobSeq;
    @Schema(description = "점검표 구분 코드")
    private String checklistDivisionCode;
    @Schema(description = "점검표 수행 ENUM")
    private ChecklistPerformEnum checklistPerformEnum;
    @Schema(description = "서식명")
    private String checklistSubject;
    @Schema(description = "점검자 아이디")
    private String inspectorId;
    @Schema(description = "점검자 이름")
    private String inspectorName;
    @Schema(description = "점검자 부서 아이디")
    private String inspectorDepartmentId;
    @Schema(description = "점검자 부서 이름")
    private String inspectorDepartmentName;
    @Schema(description = "점검 날짜")
    private LocalDate checkDt;
    @Schema(description = "점검사항")
    private String inspectionMatters;
    @Schema(description = "점검 대상")
    private String checkTarget;
    @Schema(description = "점검 장소")
    private String checkLocation;
    @Schema(description = "협력 업체")
    private String partnerCompany;
    @Schema(description = "주간 분기 코드")
    private String weekBranchCode;
    @Schema(description = "삽입 사용자 아이디")
    private String insertUserId;
    @Schema(description = "삽입 IP")
    private String insertIp;
    @Schema(description = "수정 사용자 아이디")
    private String updateUserId;
    @Schema(description = "수정 IP")
    private String updateIp;
    @Schema(description = "점검표 설문답")
    private List<ChecklistQuestionResultRequest> checklistResultList;

}
