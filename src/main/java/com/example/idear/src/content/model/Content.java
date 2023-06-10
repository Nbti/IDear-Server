package com.example.idear.src.content.model;

import com.example.idear.src.query.model.Query;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Content {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long id;
    private String content;
    @Column(columnDefinition = "TIMESTAMP")
    private String createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "query_id")
    private Query query;
}
