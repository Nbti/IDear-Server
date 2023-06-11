package com.example.idear.common;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 에러 코드 관리
 */
@Getter
public enum BaseResponseStatus {
    /**
     * 200번대(성공)
     */
    // 공통
    SUCCESS(HttpStatus.OK, "요청에 성공하였습니다."),
    SUCCESS_CREATED(HttpStatus.CREATED, "생성 되었습니다."),

    /**
     * 300번대(리다이렉트)
     */


    /**
     * 400번대(클라이언트 에러)
     */
    // 공통
    BAD_REQUEST(HttpStatus.BAD_REQUEST, "요청 값을 확인해주세요."),
    BAD_REQUEST_PARAM(HttpStatus.BAD_REQUEST, "요청 파라미터를 확인해주세요."),
    BAD_REQUST_ID(HttpStatus.BAD_REQUEST,"유저의 id 가 존재하지 않습니다"),
    EMPTY_JWT(HttpStatus.BAD_REQUEST, "빈 jwt 입니다."),
    INVALID_JWT(HttpStatus.BAD_REQUEST, "유효하지 않은 jwt 입니다."),
    JWT_MISMATCH(HttpStatus.BAD_REQUEST, "jwt 정보가 일치하지 않습니다."),
    INVALID_USER_ID(HttpStatus.BAD_REQUEST, "유효하지 않은 user id 입니다."),
    INVALID_PROFILE_ID(HttpStatus.BAD_REQUEST, "유효하지 않은 profile id 입니다."),
    INVALID_QUERY_ID(HttpStatus.BAD_REQUEST, "유효하지 않은 query id 입니다."),



    /**
     * 500번대(서버 에러)
     */
    // 공통
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "예상치 못한 서버 에러입니다. 제보 부탁드립니다.")

    ;

    private final HttpStatus httpStatus;
    private final String message;

    private BaseResponseStatus(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}