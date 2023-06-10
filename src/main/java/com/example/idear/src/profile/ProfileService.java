package com.example.idear.src.profile;

import com.example.idear.src.profile.models.Profile;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    // 프로픨 생성
    public String newProfile(ProfileReqDTO profileReqDTO) {
        Profile profile = new Profile();

        System.out.println("@@@@@@@@@@@"+profileReqDTO.getColorCode());

        profile.setName(profileReqDTO.getName());
        profile.setMbti(profileReqDTO.getMbti());
        profile.setColorCode(profileReqDTO.getColorCode());

        profileRepository.save(profile);

        return "프로필 생성 성공";
    }
}
