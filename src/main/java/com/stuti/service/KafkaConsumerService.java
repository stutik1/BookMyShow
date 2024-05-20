//package com.stuti.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Service
//public class KafkaConsumerService {
//    @Autowired
//    private KafkaTemplate<String, String> kafkaTemplate;
//    public List<String> messageList=new ArrayList<>();
//
//    @KafkaListener(topics = "guru", groupId = "test-consumer-group")
//    public void consumeMessage(String message) {
//       // Process the received message here
//        messageList.add(message);
//        System.out.println("Received message: " + message);
//    }
//}
