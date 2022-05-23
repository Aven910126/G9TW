//package com.example.GuideCane.controller;
//
//import org.springframework.http.MediaType;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
//
//import java.awt.*;
//import java.io.IOException;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//@RestController
//@RequestMapping(path = "sse/test")
//public class SseController {
//    private static Map<String, SseEmitter> sseCache = new ConcurrentHashMap<>();
//    @GetMapping(path = "subscrbie" , produces = {MediaType.TEXT_EVENT_STREAM_VALUE})
//    public SseEmitter push(String id) throws IOException{
//        SseEmitter sseEmitter = new SseEmitter((30000L));
//        sseEmitter.send(SseEmitter.event().reconnectTime(1000).data("連接成功"));
//        sseCache.put(id,sseEmitter);
//        System.out.println("add" + id);
//        sseEmitter.onTimeout(() ->{
//            System.out.println(id + "超時");
//            sseCache.remove(id);
//        });
//        sseEmitter.onCompletion(()-> System.out.println("完成！！！"));
//        return sseEmitter;
//    }
//    @GetMapping(path = "push")
//    public String push(String id,String content) throws IOException{
//        SseEmitter sseEmitter = sseCache.get(id);
//        if(sseEmitter != null){
//            sseEmitter.send(SseEmitter.event().name("msg").data("後端發送訊息" + content));
//        }
//        return "over";
//    }
//    @GetMapping(path = "over")
//    public String over(String id){
//        SseEmitter sseEmitter = sseCache.get(id);
//        if(sseEmitter != null){
//            sseEmitter.complete();
//            sseCache.remove(id);
//        }
//        return "over";
//    }
//
//}
