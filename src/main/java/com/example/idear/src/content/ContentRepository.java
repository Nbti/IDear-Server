package com.example.idear.src.content;

import com.example.idear.src.content.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
    @org.springframework.data.jpa.repository.Query("SELECT c FROM Content c WHERE c.myQuery.id = :myQueryId ORDER BY c.createdAt DESC")
    List<Content> findAllByMyQueryId(@Param("myQueryId") Long myQueryId);
}
