package com.example.idear.src.star;

import com.example.idear.src.star.Dao.Starred;
import com.example.idear.src.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StarRepository extends JpaRepository<Starred, Long> {
    List<Starred> findByUserId(User userId);

}
