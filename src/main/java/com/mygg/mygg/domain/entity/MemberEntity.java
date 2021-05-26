package com.mygg.mygg.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name = "member")
public class MemberEntity {

    private Long id;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private String phone_number;
    private String gender;
    private int age;
    private String location;
    private String photo;
    private int authority = 1;
    private LocalDateTime join_date;
    private String role;

    @Builder
    public MemberEntity(Long id, String email, String password, String name, String nickname, String phone_number, String gender, int age, String location, String photo, String authority, String join_date, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.phone_number = phone_number;
        this.gender = gender;
        this.age = age;
        this.location = location;
        this.photo = photo;
        this.authority = 1;
        this.role =role;
    }

    @PrePersist
    public void Join_date() {
        this.join_date = LocalDateTime.now();
    }
}