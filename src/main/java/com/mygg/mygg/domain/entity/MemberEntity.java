package com.mygg.mygg.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "member")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(length = 20, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String nickname;

    @Column(length = 100, nullable = false)
    private String phone_number;

    @Column(length = 100, nullable = false)
    private String gender;

    @Column(length = 100, nullable = false)
    private int age;

    @Column(length = 100, nullable = false)
    private String location;

    @Column(length = 100, nullable = true)
    private String photo;

    @Column(length = 100, nullable = true)
    private String authority;

    @Column(length = 100, nullable = true)
    private String join_date;

    @Column(length = 100, nullable = true)
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
        this.authority = authority;
        this.join_date = join_date;
        this.role =role;
    }
}
