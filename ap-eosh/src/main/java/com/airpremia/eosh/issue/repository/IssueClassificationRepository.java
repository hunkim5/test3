package com.airpremia.eosh.issue.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.airpremia.eosh.issue.entities.IssueClassificationItemEntity;
import com.airpremia.eosh.issue.enums.IssueClassificationItemEnum;

@Repository
public interface IssueClassificationRepository {
    List<IssueClassificationItemEntity> selectIssueClassificationItemList(
        @Param("issueSeq") Long issueSeq,
        @Param("codeClassification") IssueClassificationItemEnum codeClassification);

    void deleteExcludeIssueClassificationItemList(
        @Param("issueSeq") Long issueSeq,
        @Param("issueClassificationItemList") List<IssueClassificationItemEntity> issueClassificationItemList);

    List<IssueClassificationItemEntity> selectExistsIssueClassificationItemList(
        @Param("issueSeq") Long issueSeq,
        @Param("issueClassificationItemList") List<IssueClassificationItemEntity> issueClassificationItemList);

    void updateIssueClassificationItem(IssueClassificationItemEntity issueClassificationItemEntity);

    void insertIssueClassificationItem(IssueClassificationItemEntity issueClassificationItemEntity);


}
