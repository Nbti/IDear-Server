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
    public BaseResponse<ProfileReqDTO> createProfile(@RequestBody ProfileReqDTO profileReqDTO) {
//        System.out.println(profileKeywordReqDTO);
        profileService.newProfile(profileReqDTO);
        return new BaseResponse<ProfileReqDTO>(BaseResponseStatus.SUCCESS, profileReqDTO);
    }

    // 프로필 가져오기
    @GetMapping("")
    public BaseResponse<List<Profile>> findAll() {
        return new BaseResponse<List<Profile>>(BaseResponseStatus.SUCCESS, profileService.allProfile());
    }

    // 프로필 수정
    @PatchMapping("/{profileId}")
    public BaseResponse<ProfileReqDTO> editProfile(@RequestBody ProfileReqDTO profileReqDTO, @PathVariable ("profileId") String profileId) {
        profileService.patchProfile(profileReqDTO, profileId);
        return new BaseResponse<ProfileReqDTO>(BaseResponseStatus.SUCCESS, profileReqDTO);
    }

    // 프로필 삭제
    @DeleteMapping("/{profileId}")
    public BaseResponse<String> deleteProfile(@PathVariable ("profileId") String profileId) {
        profileService.deleteProfile(profileId);
        return new BaseResponse<String>(BaseResponseStatus.SUCCESS, profileId);
    }

}
