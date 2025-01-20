package com.airpremia.eosh.ca.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.airpremia.eosh.ca.enums.CaAppvalprcEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CaCollectionSearchDto {
    private String inchargeUserId;
    private String inchargeDepartmentId;
    private String caSubject;
    private LocalDateTime startInsertDtm;
    private LocalDateTime endInsertDtm;
    private LocalDate startCapExpectCompleteDt;
    private LocalDate endCapExpectCompleteDt;
    private LocalDate startCaiCompleteDt;
    private LocalDate endCaiCompleteDt;
    private CaAppvalprcEnum caAppvalprcEnum;
    private String assignedUserId;
    private List<String> accessibleDepartmentCdList;
}
