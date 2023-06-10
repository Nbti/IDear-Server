package com.example.idear.src.query.dto.response;

import com.example.idear.src.content.dto.response.ContentRes;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FirstQueryRes {
    private String dear;
    private String type;
    private String createdAt;
    private ContentRes contentRes;
}
