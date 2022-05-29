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
    @Test
    public  void sendToGmail(Gps g, List<EmergencyContact> e) throws Exception {
        SimpleMailMessage message = new SimpleMailMessage();//創建新物件
        String latitude = g.getLatitude();
        String longitude = g.getLongitude();
        String location="https://www.google.com/maps?q="+latitude+","+longitude;

        String email;
        for (EmergencyContact i:e){
            email=(i.getEmail());
            message.setFrom("a1148370488@gmail.com");//使用自己創造的物件Lod4
            message.setTo(email);
            message.setSubject("測試透過 Gmail 去發信");
            message.setText("點擊開啟位置"+location);

            mailSender.send(message);
        }
    }

}
