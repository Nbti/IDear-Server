package com.example.idear.src.query;

import com.example.idear.src.query.model.MyQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QueryRepository extends JpaRepository<MyQuery, Long> {
    @org.springframework.data.jpa.repository.Query("SELECT q FROM MyQuery q WHERE q.user.id = :userId ORDER BY q.createdAt DESC")
    List<MyQuery> findAllByUserId(Long userId);
}
