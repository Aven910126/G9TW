package com.example.GuideCane.service;



import com.example.GuideCane.model.EmergencyContact;
import com.example.GuideCane.model.Gps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = GuideCaneApplication.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Service
public class TestMail {
    @Autowired
    JavaMailSender mailSender;

    private void backupMail(String mail,String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("a1148370488@gmail.com");
        message.setTo("a1148370488@gmail.com");
        message.setSubject("已寄信通知");
        message.setText("已對"+ mail +"寄出\n內容:"+ content);

        mailSender.send(message);
    }
    @Test
    public void sendToGmail(Gps g, List<EmergencyContact> e) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();
        String latitude = g.getLatitude();
        String longitude = g.getLongitude();
        String location = "https://www.google.com/maps?q=" + latitude + "," + longitude;

        System.out.println(g.getDeviceCode().getDeviceCode());
        System.out.println(e);
        List<String> emailList = new ArrayList<>();
        for (EmergencyContact i : e) {
            System.out.println(i.getDeviceCode().getDeviceCode());
            if (i.getDeviceCode().getDeviceCode() == g.getDeviceCode().getDeviceCode()) {
                System.out.println(i);
                emailList.add(i.getEmail());
            }
        }
            message.setFrom("a1148370488@gmail.com");
        for (String str :emailList){
            if(str != null){
                message.setTo(str);
                message.setSubject("測試透過 Gmail 去發信");
                message.setText("點擊開啟位置" + location);
                mailSender.send(message);
                backupMail(str,"點擊開啟位置"+location);//Lod1使用自己的方法
            }
        }
    }
}
