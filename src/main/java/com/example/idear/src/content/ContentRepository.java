package com.example.idear.src.content;

import com.example.idear.src.content.model.Content;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContentRepository extends JpaRepository<Content, Long> {
}
