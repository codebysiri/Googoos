package com.mygg.mygg.vo;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class MemberVO {

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
    private String authority;
    private String join_date;
    private String role;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
}
