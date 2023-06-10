package com.example.idear.src.star;

import com.example.idear.common.BaseResponse;
import com.example.idear.common.BaseResponseStatus;
import com.example.idear.src.star.Dao.Starred;
import com.example.idear.src.star.Dto.RequestDto.StarredRequestDto;
import com.example.idear.src.star.Dto.ResponseDto.StarredResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mypage/content")
public class StarController {

    private final StarService starService;

    @GetMapping("")
    public BaseResponse<StarredResponseDto> starred(@RequestBody StarredRequestDto starredRequestDto) {
        StarredResponseDto starredResponseDto = starService.setStarred(starredRequestDto);
        return new BaseResponse<StarredResponseDto>(BaseResponseStatus.SUCCESS, starredResponseDto);
    }
}
