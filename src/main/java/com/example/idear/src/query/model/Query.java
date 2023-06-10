package com.example.idear.src.query.model;

import com.example.idear.src.user.model.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Query {
    @Builder
    public Query(String to, String type, String content, User user) {
        this.to = to;
        this.type = type;
        this.content = content;
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long id;
    private String to;
    private String type;
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "profile_id")
//    private Profile profile;
}
