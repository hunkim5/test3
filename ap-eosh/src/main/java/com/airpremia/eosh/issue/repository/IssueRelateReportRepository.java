package com.airpremia.eosh.issue.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.issue.entities.IssueRelateReportEntity;


@Repository
public interface IssueRelateReportRepository {

    List<IssueRelateReportEntity> selectIssueRelateReportList(Long issueSeq);

    void deleteExcludeIssueRelateReportList(
        @Param("issueSeq") Long issueSeq,
        @Param("relateReportUuidList") List<String> relateReportUuidList);

    List<IssueRelateReportEntity> selectExistsIssueRelateReportList(
        @Param("issueSeq") Long issueSeq,
        @Param("relateReportUuidList") List<String> relateReportUuidList);

    void insertIssueRelateReport(IssueRelateReportEntity saveEntity);

    List<IssueRelateReportEntity> selectBatchAllIssueRelateReportList(List<Long> issueSeqList);
}
