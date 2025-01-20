package com.airpremia.eosh.personaldetail.reportcontract.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.personaldetail.reportcontract.controller.request.EvaluationTargetChecklistRequest;
import com.airpremia.eosh.personaldetail.reportcontract.controller.request.PersonalDetailReportContractRequest;
import com.airpremia.eosh.personaldetail.reportcontract.controller.request.PersonalDetailReportContractSearchRequest;
import com.airpremia.eosh.personaldetail.reportcontract.controller.request.SafetyHealthCheckChecklistRequest;
import com.airpremia.eosh.personaldetail.reportcontract.controller.response.EvaluationTargetChecklistResponse;
import com.airpremia.eosh.personaldetail.reportcontract.controller.response.PersonalDetailContractCompanyResponse;
import com.airpremia.eosh.personaldetail.reportcontract.controller.response.PersonalDetailReportContractPageResponse;
import com.airpremia.eosh.personaldetail.reportcontract.controller.response.PersonalDetailReportContractResponse;
import com.airpremia.eosh.personaldetail.reportcontract.controller.response.SafetyHealthCheckChecklistResponse;
import com.airpremia.eosh.personaldetail.reportcontract.dto.EvaluationTargetChecklistDto;
import com.airpremia.eosh.personaldetail.reportcontract.dto.PersonalDetailReportContractDto;
import com.airpremia.eosh.personaldetail.reportcontract.dto.PersonalDetailReportContractPageDto;
import com.airpremia.eosh.personaldetail.reportcontract.dto.PersonalDetailReportContractSearchDto;
import com.airpremia.eosh.personaldetail.reportcontract.dto.SafetyHealthCheckChecklistDto;
import com.airpremia.eosh.personaldetail.reportcontract.repository.EvaluationTargetChecklistRepository;
import com.airpremia.eosh.personaldetail.reportcontract.repository.PersonalDetailReportContractRepository;
import com.airpremia.eosh.personaldetail.reportcontract.repository.SafetyHealthCheckChecklistRepository;
import com.airpremia.eosh.report.workreport.reportcontract.enums.CompanyGradeEnum;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonalDetailReportContractService {

    private final PersonalDetailReportContractRepository personalDetailReportContractRepository;
    private final EvaluationTargetChecklistRepository evaluationTargetChecklistRepository;
    private final SafetyHealthCheckChecklistRepository safetyHealthCheckChecklistRepository;

    public Page<PersonalDetailReportContractPageResponse> selectReportContractPage(
        PersonalDetailReportContractSearchRequest searchRequest, Pageable pageable) {

        PersonalDetailReportContractSearchDto dto =
            new PersonalDetailReportContractSearchDto(searchRequest);
        Page<PersonalDetailReportContractPageDto> pageDto =
            personalDetailReportContractRepository.selectReportContractPage(dto, pageable);

        return pageDto.map(PersonalDetailReportContractPageResponse::new);
    }

    public PersonalDetailReportContractResponse selectReportContract(Long contractSeq) {
        return new PersonalDetailReportContractResponse(
            personalDetailReportContractRepository.selectReportContract(contractSeq));
    }

    public List<PersonalDetailContractCompanyResponse> selectContractCompany(CompanyGradeEnum companyGradeEnum) {
        return personalDetailReportContractRepository.selectContractCompany(companyGradeEnum).stream()
            .map(PersonalDetailContractCompanyResponse::new).toList();
    }

    @Transactional
    public PersonalDetailReportContractResponse updateReportContract(
        Long contractSeq, PersonalDetailReportContractRequest request) {
        PersonalDetailReportContractDto dto = new PersonalDetailReportContractDto(request);
        personalDetailReportContractRepository.updateReportContract(dto);
        return new PersonalDetailReportContractResponse(
            personalDetailReportContractRepository.selectReportContract(contractSeq));
    }

    public List<SafetyHealthCheckChecklistResponse> selectSafetyHealthCheckChecklist(Long contractSeq) {
        return safetyHealthCheckChecklistRepository.selectSafetyHealthCheckChecklist(contractSeq).stream()
            .map(SafetyHealthCheckChecklistResponse::new).toList();
    }

    @Transactional
    public List<SafetyHealthCheckChecklistResponse> insertSafetyHealthCheckChecklist(
        List<SafetyHealthCheckChecklistRequest> requestList) {

        for (SafetyHealthCheckChecklistRequest request : requestList) {
            SafetyHealthCheckChecklistDto dto = new SafetyHealthCheckChecklistDto(request);
            safetyHealthCheckChecklistRepository.insertSafetyHealthCheckChecklist(dto);
        }
        return safetyHealthCheckChecklistRepository.selectSafetyHealthCheckChecklist(requestList.getFirst()
                .getContractSeq()).stream()
            .map(SafetyHealthCheckChecklistResponse::new).toList();
    }

    @Transactional
    public List<SafetyHealthCheckChecklistResponse> updateSafetyHealthCheckChecklist(
        List<SafetyHealthCheckChecklistRequest> requestList) {

        for (SafetyHealthCheckChecklistRequest request : requestList) {
            SafetyHealthCheckChecklistDto dto = new SafetyHealthCheckChecklistDto(request);
            safetyHealthCheckChecklistRepository.updateSafetyHealthCheckChecklist(dto);
        }
        return safetyHealthCheckChecklistRepository.selectSafetyHealthCheckChecklist(requestList.getFirst()
                .getContractSeq()).stream()
            .map(SafetyHealthCheckChecklistResponse::new).toList();
    }

    @Transactional
    public int deleteSafetyHealthCheckChecklist(Long contractSeq) {
        return safetyHealthCheckChecklistRepository.deleteSafetyHealthCheckChecklist(contractSeq);
    }

    public List<EvaluationTargetChecklistResponse> selectEvaluationTargetChecklist(Long contractSeq) {
        return evaluationTargetChecklistRepository.selectEvaluationTargetChecklist(contractSeq).stream()
            .map(EvaluationTargetChecklistResponse::new).toList();
    }

    @Transactional
    public List<EvaluationTargetChecklistResponse> insertEvaluationTargetChecklist(
        List<EvaluationTargetChecklistRequest> requestList) {

        for (EvaluationTargetChecklistRequest request : requestList) {
            EvaluationTargetChecklistDto dto = new EvaluationTargetChecklistDto(request);
            evaluationTargetChecklistRepository.insertEvaluationTargetChecklist(dto);
        }
        return evaluationTargetChecklistRepository.selectEvaluationTargetChecklist(requestList.getFirst()
                .getContractSeq()).stream()
            .map(EvaluationTargetChecklistResponse::new).toList();
    }

    @Transactional
    public List<EvaluationTargetChecklistResponse> updateEvaluationTargetChecklist(
        List<EvaluationTargetChecklistRequest> requestList) {

        for (EvaluationTargetChecklistRequest request : requestList) {
            EvaluationTargetChecklistDto dto = new EvaluationTargetChecklistDto(request);
            evaluationTargetChecklistRepository.updateEvaluationTargetChecklist(dto);
        }
        return evaluationTargetChecklistRepository.selectEvaluationTargetChecklist(requestList.getFirst()
                .getContractSeq()).stream()
            .map(EvaluationTargetChecklistResponse::new).toList();
    }

    @Transactional
    public int deleteEvaluationTargetChecklist(Long contractSeq) {
        return evaluationTargetChecklistRepository.deleteEvaluationTargetChecklist(contractSeq);
    }

}
