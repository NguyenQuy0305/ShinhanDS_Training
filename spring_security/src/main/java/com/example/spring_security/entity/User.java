package com.example.spring_security.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_db")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;
    private String password;
}
