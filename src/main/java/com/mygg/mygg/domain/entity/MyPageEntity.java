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
    private int level;
    private String wish;
    private String batch;
    private int mileage;

    @Builder
    public MyPageEntity(Long id, int level, String wish, String batch, int mileage) {
        this.id = id;
        this.level = level;
        this.wish = wish;
        this.batch = batch;
        this.mileage = mileage;
    }
}
