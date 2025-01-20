package com.airpremia.eosh.issue.dto.classification;

import java.time.LocalDateTime;

import com.airpremia.eosh.issue.entities.IssueClassificationItemEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
public class IssueClassificationItemDto {
    private String codeClassification;
    private String commonCode;
    private Long issueSeq;
    private boolean mainBool = false;
    private String remarkComment;
    private String insertUserId;
    private LocalDateTime insertDtm;
    private String insertIp;
    private String updateUserId;
    private LocalDateTime updateDtm;
    private String updateIp;

    public IssueClassificationItemDto(IssueClassificationItemEntity entity) {
        this.codeClassification = entity.getCodeClassification();
        this.commonCode = entity.getCommonCode();
        this.issueSeq = entity.getIssueSeq();
        this.mainBool = entity.isMainBool();
        this.remarkComment = entity.getRemarkComment();
        this.insertUserId = entity.getInsertUserId();
        this.insertDtm = entity.getInsertDtm();
        this.insertIp = entity.getInsertIp();
        this.updateUserId = entity.getUpdateUserId();
        this.updateDtm = entity.getUpdateDtm();
        this.updateIp = entity.getUpdateIp();
    }

    public IssueClassificationItemEntity toEntity() {
        IssueClassificationItemEntity entity = new IssueClassificationItemEntity();
        entity.setCodeClassification(this.codeClassification);
        entity.setCommonCode(this.commonCode);
        entity.setIssueSeq(this.issueSeq);
        entity.setMainBool(this.mainBool);
        entity.setRemarkComment(this.remarkComment);
        entity.setInsertUserId(this.insertUserId);
        entity.setInsertDtm(this.insertDtm);
        entity.setInsertIp(this.insertIp);
        entity.setUpdateUserId(this.updateUserId);
        entity.setUpdateDtm(this.updateDtm);
        entity.setUpdateIp(this.updateIp);
        return entity;
    }
}
