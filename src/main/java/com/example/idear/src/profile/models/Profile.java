package com.example.idear.src.profile.models;

import com.example.idear.src.user.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @Column(length = 1, name = "is_polite", columnDefinition = "TINYINT", nullable = false)
    private int is_polite;

    @Column(length = 10, name = "mbti", nullable = false)
    private String mbti;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user_id;

}
