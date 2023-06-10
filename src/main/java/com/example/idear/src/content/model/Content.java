package com.example.idear.src.content.model;

import com.example.idear.src.query.model.MyQuery;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@DynamicInsert
@Getter
@Setter
@NoArgsConstructor
public class Content {
    @Builder
    public Content(String content, MyQuery myQuery) {
        this.content = content;
        this.myQuery = myQuery;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long id;
    private String content;
    @Column(columnDefinition = "TIMESTAMP")
    private String createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "query_id", columnDefinition = "INT UNSIGNED")
    private MyQuery myQuery;
}
