package com.example.idear.src.profile;

import com.example.idear.src.profile.models.Profile;
import com.example.idear.src.profile.models.ProfileKeyword;
import com.example.idear.src.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProfileService {
    private final ProfileRepository profileRepository;
    private final ProfileKeywordRepository profileKeywordRepository;

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

        // 프로필 키워드 저장
        for (int i = 0; i < profileReqDTO.getKeyword().size(); i++) {
            ProfileKeyword profileKeyword = new ProfileKeyword();
            profileKeyword.setKeyword(profileReqDTO.getKeyword().get(i));
            profileKeyword.setProfile(profile);
            profileKeywordRepository.save(profileKeyword);
        }

        return "프로필 생성 성공";
    }

    // 프로필 가져오기
    public List<Profile> allProfile(){
        return profileRepository.findAll();
    }

    // 프로필 수정
    public String patchProfile(ProfileReqDTO profileReqDTO, String profileId) {
        Optional<Profile> profileOptional = profileRepository.findById(Long.valueOf(profileId));
        Profile profile = profileOptional.get();

        profile.setIs_polite(profileReqDTO.getIs_polite());
        profile.setMbti(profileReqDTO.getMbti());

        User user = new User();
        user.setId(1L);
        user.setName("test");
        user.setEmail("test");
        user.setPassword("test");
        profile.setUser_id(user);

        profileRepository.save(profile);

        return "프로필 수정 성공";
    }

    // 프로필 삭제
    public String deleteProfile(String profileId) {
        Optional<Profile> profileOptional = profileRepository.findById(Long.valueOf(profileId));
        Profile profile = profileOptional.get();
        profileRepository.delete(profile);
        return "회원탈퇴";
    }
}
