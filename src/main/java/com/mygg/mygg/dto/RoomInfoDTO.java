package com.mygg.mygg.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RoomInfoDTO {
    private int roomNumber;
    private String roomName;
    private List<Map<String, Object>> lists;
    private Map<String,Object> roomStatus;
    private Map<String,Object> boardStatus;
}