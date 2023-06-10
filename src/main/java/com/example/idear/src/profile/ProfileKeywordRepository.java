package com.example.idear.src.profile;

import com.example.idear.src.profile.models.ProfileKeyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileKeywordRepository extends JpaRepository<ProfileKeyword, Long> {
    List<ProfileKeyword> findByProfileId(Long profileId);
}
