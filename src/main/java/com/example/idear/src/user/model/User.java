package com.example.idear.src.user.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT UNSIGNED")
    private Long id;

    @Column(length = 10, name = "name", nullable = false)
    private String name;

    @Column(length = 50, name = "email", nullable = false)
    private String email;

    @Column(length = 255, name = "password", nullable = false)
    private String password;
}