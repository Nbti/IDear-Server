package com.example.idear.src.star.Dto.ResponseDto;

import com.example.idear.src.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StarredResponseDto {
    private Long StarredId;
    private String content;
    private LocalDateTime regdate;
    private User userId;
}
