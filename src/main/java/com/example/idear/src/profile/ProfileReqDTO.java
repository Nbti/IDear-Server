package com.example.idear.src.profile;

import lombok.Getter;

import java.util.List;

@Getter
public class ProfileReqDTO {
    private List<String> keyword;
    private String is_polite;
    private String mbti;
}
