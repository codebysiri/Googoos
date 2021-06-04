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

    //Activity
    private int level = 1;
    private String wish;
    private String batch;
    private int mileage = 0;
    private String introduction;

    @Builder
    public MemberEntity(Long id, String email, String password, String name, String nickname, String phone_number, String gender, int age, String location, String photo,
                        int authority, int level, String wish, String batch, int mileage, String introduction) {
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
        this.level = 1;
        this.wish = wish;
        this.batch = batch;
        this.mileage = 0;
        this.introduction = introduction;
    }

    @PrePersist
    public void Join_date() {
        this.join_date = LocalDateTime.now();
    }
}