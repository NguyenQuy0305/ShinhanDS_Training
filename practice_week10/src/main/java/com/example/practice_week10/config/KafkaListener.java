package com.example.practice_week10.config;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component
public class KafkaListener {

    @org.springframework.kafka.annotation.KafkaListener(
            topics = "likelion",
            groupId = "groupId"
    )
    public void listener(ConsumerRecord<String, String> record) {
        System.out.println("Listener received from kafka: " + record.value());
    }
}
