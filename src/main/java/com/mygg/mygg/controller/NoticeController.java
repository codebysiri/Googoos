package com.mygg.mygg.controller;

import com.mygg.mygg.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    @GetMapping(value={"/notice/{board_page}","/notice"})
    public String getNotices(@PathVariable(required = false) Integer board_page ,Model model){

        Double total = noticeService.getTotal();
        int totalPage = (int)Math.ceil(total/20);

        if(board_page != null){
            model.addAttribute("notices",noticeService.getNotices((board_page-1)*10*2));
            model.addAttribute("totalPage", totalPage);
        }else{
           board_page = 1;
            model.addAttribute("notices",noticeService.getNotices((board_page-1)*10*2));
            model.addAttribute("totalPage", totalPage);
        }
        return "/notice/notice";
    }

    @GetMapping("/notice/detail/{board_id}")
    public String getDetail(@PathVariable("board_id") int board_id, Model model){
        model.addAttribute("notice", noticeService.getNotice(board_id));
        return "/notice/notice_detail";
    }

    @GetMapping("/notice/write")
    public String write(){
        return "/notice/write";
    }

    @PostMapping("/notice/write")
    public String writeNotice(@RequestParam Map<String,String> writedValue){
        System.out.println("여기는 롸리트 포스트");
        noticeService.insertNotice(writedValue);
        return "redirect:/notice";
    }

    @GetMapping("/notice/update/{board_id}")
    public String updateNotice(@PathVariable("board_id") int board_id, Model model){
        model.addAttribute("notice", noticeService.getNotice(board_id));
        return "/notice/notice_update";
    }

    @PostMapping("/notice/update")
    public String updateNotice(@RequestParam Map<String,String> updatedValue){
        System.out.println("여기는 포스트업데이트입니다입니다 "+updatedValue);
        noticeService.updateNotice(updatedValue);
        return "redirect:/notice";
    }


}
