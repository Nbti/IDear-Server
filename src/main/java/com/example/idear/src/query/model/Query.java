package com.example.idear.src.query.model;

import com.example.idear.src.profile.models.Profile;
import com.example.idear.src.user.model.User;
import com.example.idear.utils.TimestampFormatter;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Query {
    @PrePersist
    public void prePersist() {
        this.createdAt = this.createdAt == null ?
                TimestampFormatter.format(new Timestamp(System.currentTimeMillis()))
                : this.createdAt;
    }
    @Builder
    public Query(String dear, String type, String content, User user, Profile profile) {
        this.dear = dear;
        this.type = type;
        this.content = content;
        this.user = user;
        this.profile = profile;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private Long id;
    private String dear;
    private String type;
    private String content;
    @Column(columnDefinition = "TIMESTAMP")
    private String createdAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profile_id")
    private Profile profile;
}
