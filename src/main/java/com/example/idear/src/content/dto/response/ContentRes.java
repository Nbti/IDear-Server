package com.example.idear.src.content.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ContentRes {
    private Long id;
    private String message;
    private String finishReason;
}
