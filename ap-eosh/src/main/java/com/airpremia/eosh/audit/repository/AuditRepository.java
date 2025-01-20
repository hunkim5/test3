package com.airpremia.eosh.audit.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.airpremia.eosh.audit.dto.AuditChecklistDto;
import com.airpremia.eosh.audit.dto.AuditDto;
import com.airpremia.eosh.audit.dto.AuditResultDto;
import com.airpremia.eosh.audit.dto.AuditSearchDto;


@Repository
public interface AuditRepository {


    int insertAuditList(AuditChecklistDto insertDto);

    int updateAuditList(AuditChecklistDto updateDto);

    int insertAuditQuestionResult(AuditResultDto insertDto);

    int updateAuditQuestionResult(AuditResultDto updateDto);

    AuditChecklistDto selectUserCheck(Long auditSeq, String inspectorName);

    AuditDto selectAuditDetail(AuditDto data);

    List<AuditSearchDto> selectAuditPage(AuditSearchDto data);

    List<AuditResultDto> selectAuditResultList(long auditChecklistSeq);

}
