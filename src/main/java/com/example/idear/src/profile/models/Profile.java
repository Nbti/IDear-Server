package com.example.idear.src.profile.models;

import com.example.idear.src.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Long id;

    @Column(name = "is_polite", columnDefinition = "TINYINT")
    private Boolean is_polite;

    @Column(name = "mbti", length = 10, nullable = false)
    private String mbti;

    @Column(name = "keyword")
    private String profileKeyword;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;
}
