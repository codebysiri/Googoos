package com.mygg.mygg.controller;

import com.mygg.mygg.dto.RoomDTO;
import com.mygg.mygg.dto.RoomInfoDTO;
import com.mygg.mygg.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Controller
public class ChatController {

    @Autowired
    ChatService chatService;

    List<RoomDTO> roomList = new ArrayList<RoomDTO>();

    static int roomNumber = 0;

//    @GetMapping("/chat")
//    public String chat(HttpServletRequest request,Model model) {
//        HttpSession session = request.getSession();
//        return "/chat/chat";
//    }

    /**
     * 방 페이지
     *
     * @return
     */
    @GetMapping("/room")
    public String room(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("nickname") != null) {
            List<Map<String, Object>> list = chatService.getChats(session.getAttribute("nickname").toString());
            model.addAttribute("lists", list);
            return "/chat/chatRoom";
        } else {
            return "redirect:/";
        }

    }

    /**
     * 방 생성하기
     *
     * @param params
     * @return
     */
    @RequestMapping("/createRoom")
    public @ResponseBody
    List<RoomDTO> createRoom(@RequestParam HashMap<Object, Object> params) {

        String roomName = (String) params.get("roomName");
        int roomNo = Integer.parseInt((String) params.get("roomNumber"));

        if (roomName != null && !roomName.trim().equals("")) {
            if (roomList == null) {
                RoomDTO room = new RoomDTO();
                room.setRoomNumber(roomNo);
                room.setRoomname(roomName);
                roomList.add(room);
            } else {
                for (int i = 0; i < roomList.size(); i++) {
                    if (roomList.get(i).getRoomNumber() == roomNo) {
                        return roomList;
                    }
                }
                RoomDTO room = new RoomDTO();
                room.setRoomNumber(roomNo);
                room.setRoomname(roomName);
                roomList.add(room);
            }
        }

        return roomList;
    }

    /**
     * 방 정보가져오기
     *
     * @param params
     * @return
     */
    @RequestMapping("/getRoom")
    public @ResponseBody
    List<RoomDTO> getRoom(@RequestParam HashMap<Object, Object> params) {
        return roomList;
    }

    /**
     * 채팅방
     *
     * @return
     */
    @GetMapping("/moveChating")
    @ResponseBody
    public RoomInfoDTO chating(@RequestParam HashMap<Object, Object> params) {

        RoomInfoDTO dto = new RoomInfoDTO();
        int roomNumber = Integer.parseInt((String) params.get("roomNumber"));

        List<RoomDTO> new_list = roomList.stream().filter(o -> o.getRoomNumber() == roomNumber).collect(Collectors.toList());
        if (new_list != null && new_list.size() > 0) {

            dto.setRoomName((String) params.get("roomName"));
            dto.setRoomNumber(roomNumber);
            dto.setLists(chatService.getChat(Integer.parseInt((String) params.get("roomNumber"))));
            dto.setRoomStatus(chatService.getRoomStatus(Integer.parseInt((String) params.get("roomNumber"))));
            dto.setBoardStatus(chatService.getMarket(Integer.parseInt((String) params.get("roomNumber"))));
            System.out.println("룸 상태는~~~~~~~~~~~~~~~~"+dto.getRoomStatus());
            return dto;
        } else {

            return dto;
        }
    }


    @PostMapping("/insertChat")
    @ResponseBody
    public int insertChat(@RequestBody HashMap<String, Object> form_value) {


        int room_id = Integer.parseInt((String) form_value.get("room_id"));
        String chat_writer = (String) form_value.get("chat_writer");
        String chat_content = (String) form_value.get("chat_content");


        return chatService.insertChat(form_value);

    }

    @PostMapping("/matchChatting")
    @ResponseBody
    public String matchChatting(@RequestBody HashMap<String,Object> value, HttpServletRequest request){
        HttpSession session  = request.getSession();
        value.put("mynick",session.getAttribute("nickname"));

        List<Map<String, Object>> chats = chatService.getChats(session.getAttribute("nickname").toString());

        for(Map<String,Object> chat : chats){

            if ((int)chat.get("service_no") == Integer.parseInt((String)value.get("service_no"))) {
                System.out.println("중복된 방");
                return "already";
            }
        }

        System.out.println(value);
        chatService.insertChatRoom(value);
        return "good";

    }

    @PostMapping("/accept")
    @ResponseBody
    public int acceptOrder(@RequestBody HashMap<String,Object> acceptValue){
        return chatService.accept(acceptValue);
    }

    @PostMapping("/getNowChat")
    @ResponseBody
    public List<Map<String,Object>> getNowChat(@RequestBody HashMap<String,Object> room_id){
        return chatService.getChat((int)room_id.get("room_id"));
    }

    @GetMapping("goReview/{roomId}/{userNick}")
    public String goReview(@PathVariable int roomId, @PathVariable String userNick,Model model){
        model.addAttribute("roomId", roomId);
        model.addAttribute("userNick", userNick);
        return "/chat/review";
    }

    @PostMapping("/review")
    public String successReview(@RequestParam HashMap<String,Object> formData){
        System.out.println(formData);

        double kindInput = Double.parseDouble((String)formData.get("kindInput"));
        double wellInput = Double.parseDouble((String)formData.get("wellInput"));
        double inTimeInput = Double.parseDouble((String)formData.get("inTimeInput"));
        int average = (int)Math.ceil((kindInput + wellInput + inTimeInput) / 3);



        return "redirect:/";
    }


}