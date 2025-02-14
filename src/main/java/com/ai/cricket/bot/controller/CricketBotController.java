package com.ai.cricket.bot.controller;


import com.ai.cricket.bot.service.ChatService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("api/v1/cricket-bot")
public class CricketBotController {

    @Autowired
    private ChatService chatService;

    public ResponseEntity getResponse(@RequestParam (name="inputText") String inputText) throws IOException {
        return  ResponseEntity.ok(chatService.getResponse(inputText));
    }


}
