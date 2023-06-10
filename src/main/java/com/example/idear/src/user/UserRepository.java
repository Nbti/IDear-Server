package com.example.idear.src.user;

import com.example.idear.src.star.Dao.Starred;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

}
