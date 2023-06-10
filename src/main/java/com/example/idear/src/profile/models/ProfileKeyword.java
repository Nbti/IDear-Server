package com.example.idear.src.profile.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "profile_keyword")
public class ProfileKeyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Long id;

    @Column(length = 10, name = "keyword", nullable = false)
    private String keyword;

    @ManyToOne
    @JoinColumn(name="profile")
    private Profile profile;

}
