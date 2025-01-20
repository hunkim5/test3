package com.airpremia.eosh.risk.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;
import com.airpremia.eosh.risk.dto.likelihood.CodeRiskLikelihoodClassificationDto;
import com.airpremia.eosh.risk.dto.risk.CodeRiskDto;
import com.airpremia.eosh.risk.dto.severity.CodeRiskSeverityClassificationDto;
import com.airpremia.eosh.risk.entities.CodeRiskEntity;
import com.airpremia.eosh.risk.entities.CodeRiskLikelihoodClassificationEntity;
import com.airpremia.eosh.risk.entities.CodeRiskSeverityClassificationEntity;
import com.airpremia.eosh.risk.entities.VersionRiskEntity;
import com.airpremia.eosh.risk.enums.LikliHoodsEnum;
import com.airpremia.eosh.risk.enums.SeverityEnum;
import com.airpremia.eosh.risk.repository.CodeRiskLikelihoodRepository;
import com.airpremia.eosh.risk.repository.CodeRiskRepository;
import com.airpremia.eosh.risk.repository.CodeRiskSeverityRepository;
import com.airpremia.eosh.risk.repository.VersionRiskRepository;
import com.airpremia.eosh.risk.request.RiskCodeDetailRequest;
import com.airpremia.eosh.risk.response.RiskCodeDetailResponse;
import com.airpremia.eosh.risk.response.VersionRiskCollectionResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;


@Service
@RequiredArgsConstructor
@Slf4j
public class RiskManageService {
    private final CodeRiskRepository codeRiskRepository;
    private final VersionRiskRepository versionRiskRepository;
    private final CodeRiskSeverityRepository codeRiskSeverityRepository;
    private final CodeRiskLikelihoodRepository codeRiskLikelihoodRepository;

    public List<VersionRiskCollectionResponse> selectRiskVersionList() {
        return versionRiskRepository.selectRiskVersionList().stream()
            .map(VersionRiskCollectionResponse::new)
            .toList();
    }

    public RiskCodeDetailResponse selectRiskDetail(Long riskVersionSeq) {
        VersionRiskEntity versionRiskEntity = versionRiskRepository.selectRiskDetail(riskVersionSeq);
        if (versionRiskEntity == null) {
            throw new ExpectedException(ExceptionCode.NOT_FOUND_RISK_VERSION);
        }

        RiskCodeDetailResponse result = new RiskCodeDetailResponse(versionRiskEntity);

        result.setRiskCodeList(
            codeRiskRepository.selectCodeRiskList(riskVersionSeq).stream().map(CodeRiskDto::new).toList()
        );

        result.setLikelihoodClassificationList(
            codeRiskLikelihoodRepository.selectRiskLikelihoodClassificationList(riskVersionSeq).stream()
                .map(CodeRiskLikelihoodClassificationDto::new).toList()
        );

        result.setSeverityClassificationList(
            codeRiskSeverityRepository.selectRiskSeverityClassificationList(riskVersionSeq).stream()
                .map(CodeRiskSeverityClassificationDto::new).toList());

        return result;
    }

    @Transactional
    public RiskCodeDetailResponse insertRiskDetail(RiskCodeDetailRequest request) {
        if (request == null || request.getRiskVersionSeq() != null) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }

        if (request.getRiskVersionYyyy() == null) {
            String currentYearVersion = String.valueOf(LocalDate.now().getYear());
            request.setRiskVersionYyyy(currentYearVersion);
        }

        VersionRiskEntity saveEntity = request.toVerseVersionRiskEntity();

        versionRiskRepository.insertRiskVersion(saveEntity);

        request.setRiskVersionSeq(saveEntity.getRiskVersionSeq());

        saveRisk(request);

        return selectRiskDetail(request.getRiskVersionSeq());
    }

    @Transactional
    public RiskCodeDetailResponse updateRiskDetail(Long riskVersionSeq, RiskCodeDetailRequest request) {
        if (request == null || riskVersionSeq == null || request.getRiskVersionYyyy() == null) {
            throw new ExpectedException(ExceptionCode.WRONG_DATA);
        }

        saveRisk(request);

        return selectRiskDetail(request.getRiskVersionSeq());
    }

    private void saveRisk(RiskCodeDetailRequest request) {
        List<CodeRiskEntity> riskList = request.getRiskCodeList();

        if (riskList == null
            ||
            request.getRiskCodeList().size() != LikliHoodsEnum.getTotalCount() * SeverityEnum.getTotalCount()
        ) {
            log.info(
                "잘못된 risk code 의 값.행렬의 값의 크기 만큼 있어야합니다. {} x {}",
                LikliHoodsEnum.values(),
                SeverityEnum.values()
            );

            throw new ExpectedException(ExceptionCode.NOT_CORRECT_RISK_CODE);
        }
        Long riskVersionSeq = request.getRiskVersionSeq();
        List<CodeRiskEntity> allList = codeRiskRepository.selectExistsRiskCodeList(riskVersionSeq);

        List<CodeRiskEntity> insertList = riskList.stream().filter(
            x -> allList.stream().noneMatch(matcher -> matcher.getRiskCode().equals(x.getRiskCode()))
        ).toList();

        List<CodeRiskEntity> updateList = riskList.stream().filter(x ->
            allList.stream().anyMatch(matcher -> matcher.getRiskCode().equals(x.getRiskCode()))).toList();

        insertList.forEach(x -> {
                x.setRiskVersionSeq(riskVersionSeq);
                codeRiskRepository.insertRiskCode(x);
            }
        );

        updateList.forEach(x -> {
            x.setRiskVersionSeq(riskVersionSeq);
            codeRiskRepository.updateRiskCode(x);
        });

        saveRiskLikelihoodClassification(request.getLikelihoodClassificationList(), riskVersionSeq);

        saveRiskSeverityClassification(request.getSeverityClassificationList(), riskVersionSeq);
    }

    private void saveRiskLikelihoodClassification(
        List<CodeRiskLikelihoodClassificationDto> likelihoodClassificationList, Long riskVersionSeq
    ) {
        if (likelihoodClassificationList != null) {
            CodeRiskLikelihoodClassificationEntity classificationEntity = new CodeRiskLikelihoodClassificationEntity();
            classificationEntity.setRiskVersionSeq(riskVersionSeq);

            List<Long> classificationSeqList = likelihoodClassificationList
                .stream()
                .map(CodeRiskLikelihoodClassificationDto::getLikelihoodClassificationSeq)
                .toList();

            codeRiskLikelihoodRepository.deleteRiskLikelihoodClassificationList(
                classificationEntity, classificationSeqList);

            likelihoodClassificationList
                .forEach(x -> {
                    x.setRiskVersionSeq(riskVersionSeq);

                    if (x.getLikelihoodClassificationSeq() == null) {
                        codeRiskLikelihoodRepository.insertRiskLikelihoodClassification(
                            x.toCodeRiskLikelihoodClassificationEntity());
                    } else {
                        codeRiskLikelihoodRepository.updateRiskLikelihoodClassification(
                            x.toCodeRiskLikelihoodClassificationEntity());
                    }
                });
        }
    }

    private void saveRiskSeverityClassification(
        List<CodeRiskSeverityClassificationDto> severityClassificationList, Long riskVersionSeq
    ) {
        if (severityClassificationList != null) {
            CodeRiskSeverityClassificationEntity severityEntity = new CodeRiskSeverityClassificationEntity();
            severityEntity.setRiskVersionSeq(riskVersionSeq);

            List<Long> severityClassificationSeqList = severityClassificationList
                .stream()
                .map(CodeRiskSeverityClassificationDto::getSeverityClassificationSeq)
                .toList();

            codeRiskSeverityRepository.deleteRiskSeverityClassificationList(severityEntity,
                severityClassificationSeqList);

            severityClassificationList
                .forEach(x -> {
                    x.setRiskVersionSeq(riskVersionSeq);

                    if (x.getSeverityClassificationSeq() == null) {
                        codeRiskSeverityRepository.insertRiskSeverityClassification(
                            x.toCodeRiskSeverityClassificationEntity());
                    } else {
                        codeRiskSeverityRepository.updateRiskSeverityClassification(
                            x.toCodeRiskSeverityClassificationEntity());
                    }
                });
        }
    }
}
