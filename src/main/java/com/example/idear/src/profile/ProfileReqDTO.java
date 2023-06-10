package com.example.idear.src.profile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ProfileReqDTO {
    private List<String> keyword;
    private Boolean is_polite;
    private String mbti;
    private String profileKeyword;
}
