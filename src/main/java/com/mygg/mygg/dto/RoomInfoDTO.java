package com.mygg.mygg.dto;

import lombok.Data;
import java.util.List;
import java.util.Map;

public class RoomInfoDTO {
    private int roomNumber;
    private String roomName;
    private List<Map<String, Object>> lists;
}
