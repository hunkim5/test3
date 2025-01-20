package com.airpremia.eosh.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
    1xxx: 공통 시스템 에러
    2xxx: 클라이언트 요청 에러 (잘못된 입력)
    3xxx: 서버 내부 에러
    4xxx: 데이터베이스 에러
    5xxx: 네트워크 또는 외부 API 에러
*/
@AllArgsConstructor
@Getter
public enum ExceptionCode {
    INSTRUCTOR_DUPLICATE(2001, "이미 등록된 강사가 존재합니다."),
    WRONG_DATA(2002, "입력된 데이터가 유효하지 않습니다."),
    NOT_FOUND_ISSUE(3001, "ISSUE 데이터가 존재하지 않습니다."),
    NOT_FOUND_RISK_VERSION(3002, "Risk Version 을 찾을 수 없습니다."),
    NOT_CORRECT_RISK_CODE(3003, "잘못된 RISK CODE 의 요청입니다."),
    NOT_FOUND_USER(5001, "사용자를 찾을수 없습니다."),
    FCM_SEND_INTERRUPTED(5002, "FCM 메시지 전송 중 중단됨"),
    FCM_SEND_FAILED(5003, "FCM 메시지 전송 실패"),
    WORKBOOK_IOEXCEPTION_ERROR(5004, "Excel 업로드 실패."),
    MESSAGE_API_REQUEST_FAILED(5005, "강사등록 메시지 전송 실패"),
    DATA_EMPTY(5006, "조회 가능한 부서가 없습니다.");

    private final int code;
    private final String message;
}
