package com.mygg.mygg.dto;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MyPageDTO {

    private Long id;
    private int level;
    private String wish;
    private String batch;
    private int mileage;

    @Builder
    public MyPageDTO(Long id, int level, String wish, String batch, int mileage) {
        this.id = id;
        this.level = level;
        this.wish = wish;
        this.batch = batch;
        this.mileage = mileage;
    }
}
