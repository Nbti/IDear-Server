package com.example.idear.src.profile;

import com.example.idear.src.profile.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Long> {

}
