package com.example.idear.src.profile;

import com.example.idear.src.profile.models.Profile;
import com.example.idear.src.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    // 프로픨 생성
    public String newProfile(ProfileReqDTO profileReqDTO) {
        Profile profile = new Profile();

        profile.setName(profileReqDTO.getName());
        profile.setMbti(profileReqDTO.getMbti());
        profile.setColorCode(profileReqDTO.getColorCode());

        User user = new User();
        user.setId(1L);
        user.setName("test");
        user.setEmail("test");
        user.setPassword("test");
        profile.setUser_id(user);

        profileRepository.save(profile);

        return "프로필 생성 성공";
    }
}
