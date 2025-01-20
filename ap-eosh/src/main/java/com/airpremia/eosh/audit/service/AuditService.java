package com.airpremia.eosh.audit.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.audit.controller.AuditChecklistRequest;
import com.airpremia.eosh.audit.controller.AuditChecklistResponse;
import com.airpremia.eosh.audit.controller.AuditRequest;
import com.airpremia.eosh.audit.controller.AuditResponse;
import com.airpremia.eosh.audit.controller.AuditSearchRequest;
import com.airpremia.eosh.audit.controller.AuditSearchResponse;
import com.airpremia.eosh.audit.dto.AuditChecklistDto;
import com.airpremia.eosh.audit.dto.AuditDto;
import com.airpremia.eosh.audit.dto.AuditResultDto;
import com.airpremia.eosh.audit.dto.AuditSearchDto;
import com.airpremia.eosh.audit.repository.AuditRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditService {

    private final AuditRepository auditRepository;

    public List<AuditSearchResponse> selectAuditPage(AuditSearchRequest req) {
        AuditSearchDto searchDto = new AuditSearchDto(req);
        List<AuditSearchDto> res = auditRepository.selectAuditPage(searchDto);

        List<AuditSearchResponse> auditSearchResponses = new ArrayList<>();
        for (AuditSearchDto auditSearchDto : res) {
            auditSearchResponses.add(new AuditSearchResponse(auditSearchDto));
        }

        return auditSearchResponses;
    }

    public AuditResponse selectAuditDetail(AuditRequest req) {
        AuditDto dto = new AuditDto(req);
        AuditDto res = auditRepository.selectAuditDetail(dto);
        return new AuditResponse(res);
    }

    public AuditChecklistResponse selectUserCheck(Long auditSeq, String inspectorName) {
        AuditChecklistDto dto = auditRepository.selectUserCheck(auditSeq, inspectorName);

        if (dto == null) {
            dto = new AuditChecklistDto();
        }

        Long auditChecklistSeq = dto.getAuditChecklistSeq();
        if (auditChecklistSeq != null) {
            List<AuditResultDto> auditResultList = auditRepository.selectAuditResultList(auditChecklistSeq);
            dto.setAuditResultDto(auditResultList != null ? auditResultList : Collections.emptyList());
        } else {
            dto.setAuditResultDto(Collections.emptyList());
        }

        return dto.convertAuditListResponse();
    }

    @Transactional
    public Integer insertOrUpdateAudit(AuditChecklistRequest req) {
        AuditChecklistDto dto = new AuditChecklistDto(req);
        int result = 0;

        if (dto.getAuditChecklistSeq() == null) {
            result += auditRepository.insertAuditList(dto);
        } else {
            result += auditRepository.updateAuditList(dto);
        }

        Long auditChecklistSeq = dto.getAuditChecklistSeq();
        if (auditChecklistSeq != null) {
            dto.getAuditResultDto().forEach(auditResultDto -> auditResultDto.setAuditChecklistSeq(auditChecklistSeq));
        }
        for (AuditResultDto auditResultDto : dto.getAuditResultDto()) {
            if (auditResultDto.getAuditChecklistQuestionResultSeq() == null) {
                result += auditRepository.insertAuditQuestionResult(auditResultDto);
            } else {
                result += auditRepository.updateAuditQuestionResult(auditResultDto);
            }
        }

        return result;
    }
}
