package com.airpremia.eosh.committee.controller.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class MeetingContractorSafetyHealthRequest {
    @Schema(description = "회의 참석 사용자 시퀀스")
    private Long meetingAttendUserSeq;
    @Schema(description = "협력금지 유해작업의 협력 여부")
    private boolean contractorBool;
    @Schema(description = "안전보건 조치 필요성 여부")
    private boolean safetyHealthActionBool;
    @Schema(description = "안전 대상 여부")
    private boolean safetyAuthTargetProcBool;
    @Schema(description = "위생시설 설치 장소 제공 또는 이용에 대한 협조 필요성 여부 -휴게시설, 세면시설, 세탁시설, 탈의시설, 수면시설")
    private String cleanInstallPlace;
    @Schema(description = "위험성평가 실시 여부 및 기계기구, 설비 등의 위험요인 공유")
    private String hazardProcShare;
    @Schema(description = "채용 변경 시교육")
    private String hireChangeEdu;
    @Schema(description = "정기 안전보건 교육")
    private String regularSpecialEdu;
    @Schema(description = "관리감독자 교육")
    private String managerEdu;
    @Schema(description = "안전보건관리책임자, 안전관리자, 보건관리자 신규&보수교육")
    private String managerRepairEdu;
    @Schema(description = "작업_휴식 시간조정")
    private String workRestAdjTime;
    @Schema(description = "작업또는 작업장 간의 연락방법 구축 및 최신화")
    private String workPlacePhoneBuild;
    @Schema(description = "재해발생 대피 방법")
    private String disasterOccurrenceEvacuationMethod;
    @Schema(description = "상호간 연락 및 작업공정")
    private String interchangePhoneWork;
    @Schema(description = "작업내용 변경시 교육")
    private String workChangeEdu;
    @Schema(description = "특별안전 교육")
    private String specialSafetyEdu;
    @Schema(description = "의견 comment")
    private String opinionComment;
    @Schema(description = "사진 다중 파일 UUID")
    private String pictureMultipleFileUuid;
    @Schema(description = "다중 파일 UUID")
    private String multipleFileUuid;
}
