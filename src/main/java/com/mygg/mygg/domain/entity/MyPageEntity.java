package com.mygg.mygg.domain.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Table;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Table(name ="memberActivity")
public class MyPageEntity {

    private Long id;
    private int level = 1;
    private String wish = null;
    private String batch = null;
    private int mileage = 0;
    private String introduction = null;

    @Builder
    public MyPageEntity(Long id, int level, String wish, String batch, int mileage, String introduction) {
        this.id = id;
        this.level = 1;
        this.wish = null;
        this.batch = null;
        this.mileage = 0;
        this.introduction = null;
    }
}