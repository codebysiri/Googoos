package com.mygg.mygg.dto;

import com.mygg.mygg.domain.entity.MemberEntity;
import lombok.*;

import javax.persistence.Column;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MemberDto {
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

    public MemberEntity toEntity(){
        return MemberEntity.builder()
                .id(id)
                .email(email)
                .password(password)
                .name(name)
                .nickname(nickname)
                .phone_number(phone_number)
                .gender(gender)
                .age(age)
                .location(location)
                .photo(photo)
                .authority(authority)
                .join_date(join_date)
                .role(role)
                .build();
    }

    @Builder
    public MemberDto(Long id, String email, String password, String name, String nickname, String phone_number, String gender, int age, String location, String photo, String authority, String join_date, String role) {
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
