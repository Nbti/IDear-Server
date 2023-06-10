package com.example.idear.src.profile;

import com.example.idear.common.BaseResponse;
import com.example.idear.common.BaseResponseStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mypage/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    // 프로필 생성
    @PostMapping("/{userId}")
    public BaseResponse<ProfileReqDTO> saveOrder(@RequestBody ProfileReqDTO profileReqDTO, @PathVariable ("userId") String userId) {
        profileService.newProfile(profileReqDTO);
        return new BaseResponse<ProfileReqDTO>(BaseResponseStatus.SUCCESS, profileReqDTO);
    }

}
