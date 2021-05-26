package com.mygg.mygg.controller;

import com.google.gson.JsonObject;
import com.mygg.mygg.service.NoticeService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
public class NoticeRestController {

    @Autowired
    NoticeService noticeService;

    @PostMapping("notice/delete/{board_id}")
    public int deleteNotice(@PathVariable("board_id") int board_id){
        return noticeService.deleteNotice(board_id);
    }

    @PostMapping("/notice/search")
    public List<Map<String,Object>> searchNotices(@RequestParam Map<String,String> searchValue,Model model){
        System.out.println(searchValue);
        System.out.println(noticeService.searchNotices(searchValue));
        return noticeService.searchNotices(searchValue);
    }

    @PostMapping("/notice/reply/{board_id}")
    public List<Map<String,Object>> getReply(@PathVariable("board_id") int board_id){
        return noticeService.getReply(board_id);
    }

    @PostMapping("/notice/insetReply")
    public int insertReply(@RequestBody Map<String,String> json){
        System.out.println(json);
        return noticeService.insertReply(json);
    }

    @PostMapping("/notice/reply/update")
    public int updateReply(@RequestBody Map<String,String> json){
        return noticeService.updateReply(json);
    }

    @PostMapping("/notice/reply/delete")
    public int deleteReply(@RequestBody int reply_id){
        return noticeService.deleteReply(reply_id);
    }

    @PostMapping(value = "/uploadImage", produces = "application/json")
    public JsonObject uploadSummernoteImageFile(@RequestParam("file")MultipartFile multipartFile){

        JsonObject jsonObject = new JsonObject();

        String fileRoot = "C:\\summernote_image\\"; //저장될 경로
        String originalFileName = multipartFile.getOriginalFilename();
        String extension = originalFileName.substring(originalFileName.lastIndexOf('.'));

        // 랜덤 UUID+ 확장자로 저장될 파일이름
        String savedFileName = UUID.randomUUID() + extension;

        File targetFile = new File(fileRoot + savedFileName);

        try {

            InputStream fileStream = multipartFile.getInputStream();
            FileUtils.copyInputStreamToFile(fileStream, targetFile); //파일 저장
            jsonObject.addProperty("url","/summernoteImage/"+savedFileName);
            jsonObject.addProperty("responseCode","success");

        }catch (IOException e){

            FileUtils.deleteQuietly(targetFile);	// 실패시 저장된 파일 삭제
            jsonObject.addProperty("responseCode", "error");
            e.printStackTrace();

        }

        return jsonObject;
    }

}
