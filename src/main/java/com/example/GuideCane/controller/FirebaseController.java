package com.example.GuideCane.controller;

import com.example.GuideCane.model.Note;
import com.example.GuideCane.service.FirebaseMessagingService;
import com.google.firebase.messaging.FirebaseMessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/Firebase")
public class FirebaseController {
    @Autowired
    FirebaseMessagingService firebaseMessagingService;


    @RequestMapping("/send-notification")
    @ResponseBody
    public String sendNotification(@RequestBody Note note,@RequestParam String token) throws FirebaseMessagingException {
        return firebaseMessagingService.sendNotification(note, token);
    }
}
