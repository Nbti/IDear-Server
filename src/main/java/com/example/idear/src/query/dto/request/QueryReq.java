package com.example.idear.src.query.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class QueryReq {
    private String to;
    private String type;
    private String content;
    private Long userId;
    private Long profileId;
}
