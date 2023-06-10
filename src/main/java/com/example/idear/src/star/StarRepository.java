package com.example.idear.src.star;

import com.example.idear.src.star.Dao.Starred;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StarRepository extends JpaRepository<Starred, Long> {


}
