package br.gabnsoares.dev.demojpa.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_users")
public class UserEntity {
    // tabala de usuário - entidade

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId; //primary key

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Long age;

    @Column(name = "createdAt")
    private LocalDateTime createdAt;

    public UserEntity() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
