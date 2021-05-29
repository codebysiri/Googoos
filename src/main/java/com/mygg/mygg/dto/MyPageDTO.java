package com.mygg.mygg.dto;

import com.mygg.mygg.domain.entity.MyPageEntity;
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

    public MyPageEntity toEntity(){
        return MyPageEntity.builder()
                .id(id)
                .level(level)
                .wish(wish)
                .batch(batch)
                .mileage(mileage)
                .build();
    }

    @Builder
    public MyPageDTO(Long id, int level, String wish, String batch, int mileage) {
        this.id = id;
        this.level = level;
        this.wish = wish;
        this.batch = batch;
        this.mileage = mileage;
    }
}
