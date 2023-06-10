package com.example.idear.src.profile;

import com.example.idear.src.profile.models.Profile;
import com.example.idear.src.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;

    // 프로픨 생성
    public String newProfile(ProfileReqDTO profileReqDTO) {
        Profile profile = new Profile();

        profile.setIs_polite(profileReqDTO.getIs_polite());
        profile.setMbti(profileReqDTO.getMbti());

        User user = new User();
        user.setId(1L);
        user.setName("test");
        user.setEmail("test");
        user.setPassword("test");
        profile.setUser_id(user);

        profileRepository.save(profile);

        return "프로필 생성 성공";
    }

    // 프로필 가져오기
    public List<Profile> allProfile(String userId){
        return profileRepository.findAll();
    }
}
