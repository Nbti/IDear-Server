package com.example.idear.exception;

import com.example.idear.common.BaseResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

// unchecked exception을 위해 RuntimeException을 상속받음
@Getter
@Setter
@AllArgsConstructor
public class BaseException extends RuntimeException {
    private BaseResponseStatus status;
}
