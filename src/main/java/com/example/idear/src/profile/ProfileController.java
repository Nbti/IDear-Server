package com.example.idear.src.profile;

import com.example.idear.common.BaseResponse;
import com.example.idear.common.BaseResponseStatus;
import com.example.idear.src.profile.models.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/mypage/profile")
public class ProfileController {
    @Autowired
    ProfileService profileService;

    // 프로필 생성
    @PostMapping("")
    public BaseResponse<ProfileReqDTO> saveOrder(@RequestBody ProfileReqDTO profileReqDTO) {
        profileService.newProfile(profileReqDTO);
        return new BaseResponse<ProfileReqDTO>(BaseResponseStatus.SUCCESS, profileReqDTO);
    }

    // 프로필 가져오기
    @GetMapping("")
    public BaseResponse<List<Profile>> findAll() {
        return new BaseResponse<List<Profile>>(BaseResponseStatus.SUCCESS, profileService.allProfile());
    }
}
