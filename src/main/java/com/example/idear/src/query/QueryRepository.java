package com.example.idear.src.query;

import com.example.idear.src.query.model.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QueryRepository extends JpaRepository<Query, Long> {
}
