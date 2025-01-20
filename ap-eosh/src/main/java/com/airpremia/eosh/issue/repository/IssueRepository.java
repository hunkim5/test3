package com.airpremia.eosh.issue.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.issue.dto.issue.IssueCollectionSearchDto;
import com.airpremia.eosh.issue.entities.IssueEntity;


@Repository
public interface IssueRepository {
    Page<IssueEntity> selectIssuePage(
        @Param(value = "searchDto") IssueCollectionSearchDto searchDto, Pageable pageable);

    List<IssueEntity> selectIssueList(
        @Param(value = "searchDto") IssueCollectionSearchDto searchDto);

    Integer createIssue(IssueEntity saveIssueEntity);

    String selectMaxIssueId();

    List<IssueEntity> selectDetailBatchByReportUuids(List<String> reportUuidList);

    Integer updateIssueSourceId(IssueEntity issueEntity);

    void updateInvestigationProcessBool(IssueEntity saveEntity);

    int updateIssueDropBoolTrue(IssueEntity issueEntity);

    IssueEntity selectDetailByIssueSeq(Long issueSeq);

    IssueEntity selectDetailByReportUuid(String reportUuid);

    String selectReportUuidByIssueSeq(Long issueSeq);
}
