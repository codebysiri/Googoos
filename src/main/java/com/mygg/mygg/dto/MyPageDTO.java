package com.mygg.mygg.dto;

import com.mygg.mygg.domain.entity.MyPageEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MyPageDTO {

    private Long id;
    private int level = 1;
    private String wish = null;
    private String batch = null;
    private int mileage = 0;
    private String introduction = null;

    public MyPageEntity toEntity(){
        return MyPageEntity.builder()
                .id(id)
                .level(1)
                .wish(null)
                .batch(null)
                .mileage(0)
                .introduction(null)
                .build();
    }

    @Builder
    public MyPageDTO(Long id, int level, String wish, String batch, int mileage, String introduction) {
        this.id = id;
        this.level = 1;
        this.wish = null;
        this.batch = null;
        this.mileage = 0;
        this.introduction = null;
    }
}