package com.airpremia.eosh.issue.component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.airpremia.eosh.exceptions.ExceptionCode;
import com.airpremia.eosh.exceptions.ExpectedException;
import com.airpremia.eosh.issue.dto.issue.IssueCreateInitialPropertyDto;
import com.airpremia.eosh.issue.dto.issue.MainToReportMappingDto;
import com.airpremia.eosh.issue.entities.IssueEntity;
import com.airpremia.eosh.issue.entities.IssueRelateReportEntity;
import com.airpremia.eosh.issue.repository.IssueRelateReportRepository;
import com.airpremia.eosh.issue.repository.IssueRepository;
import com.airpremia.eosh.usertoken.dto.UserTokenDto;
import com.airpremia.eosh.usertoken.service.UserTokenService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class IssueComponent {
    private final IssueRepository issueRepository;
    private final IssueRelateReportRepository issueRelateReportRepository;
    private final UserTokenService userTokenService;

    @Transactional
    public Long createIssueByReport(IssueCreateInitialPropertyDto issueCreateInitialPropertyDto) {

        IssueEntity saveIssueEntity = new IssueEntity(issueCreateInitialPropertyDto);

        UserTokenDto userTokenDto = userTokenService.getUserToken();
        saveIssueEntity.setInitialIssuePropertyCreateByReport(userTokenDto);
        saveIssueEntity.setIssueId(generateReportId(LocalDate.now().getYear()));

        issueRepository.createIssue(saveIssueEntity);

        return saveIssueEntity.getIssueSeq();
    }

    @Transactional
    public int issueDropByReportUuid(String reportUuid) {
        IssueEntity issueEntity = issueRepository.selectDetailByReportUuid(reportUuid);

        issueEntity.setIssueDropBool(true);

        return issueRepository.updateIssueDropBoolTrue(issueEntity);
    }

    public List<MainToReportMappingDto> getIssueInformationByReportUuids(List<String> reportUuidList) {

        if (reportUuidList.isEmpty()) {
            return Collections.emptyList();
        }

        List<IssueEntity> mainReportIssueEntityList = issueRepository.selectDetailBatchByReportUuids(reportUuidList);
        if (mainReportIssueEntityList.isEmpty()) {
            throw new ExpectedException(ExceptionCode.NOT_FOUND_ISSUE);
        }


        List<Long> mainReportIssueSeqList = mainReportIssueEntityList.stream().map(IssueEntity::getIssueSeq).toList();

        List<IssueRelateReportEntity> issueRelateReportEntityList =
            issueRelateReportRepository.selectBatchAllIssueRelateReportList(mainReportIssueSeqList);

        return mainReportIssueEntityList.stream().map(issueEntity -> {
            List<String> relateReportUuidList = issueRelateReportEntityList.stream()
                .filter(relateReportEntity -> issueEntity.getIssueSeq().equals(relateReportEntity.getIssueSeq()))
                .map(IssueRelateReportEntity::getReportUuid).toList();

            return new MainToReportMappingDto(issueEntity.getReportUuid(), issueEntity.isOrganizationAlarmBool(),
                issueEntity.getIssueProcessingEnum(), relateReportUuidList);
        }).toList();
    }

    public String getReportUuidByIssueSeq(Long issueSeq) {
        return issueRepository.selectReportUuidByIssueSeq(issueSeq);
    }

    private String generateReportId(Integer year) {
        return Optional.ofNullable(issueRepository.selectMaxIssueId())
            .filter(reportId -> reportId.split("-").length == 3 && reportId.split("-")[1].equals(String.valueOf(year)))
            .map(reportId -> String.format("A-%d-%04d", year, Integer.parseInt(reportId.split("-")[2]) + 1))
            .orElse(String.format("A-%d-0001", year));
    }
}
