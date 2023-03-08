package com.example.practice_week10.controller;

import com.example.practice_week10.config.KafkaDynamicConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DynamicTopicController {
    @Autowired
    private KafkaDynamicConfig kafkaDynamicConfig;

    @PostMapping("createTopic")
    public ResponseEntity<String> createTopic(@RequestParam String newTopic) {
        kafkaDynamicConfig.createDynamicTopic(newTopic);
        return ResponseEntity.ok("Topic " + newTopic + " create successfully");
    }

    @DeleteMapping("deleteTopic")
    public ResponseEntity<String> deleteTopic(@RequestParam String topic) {
        kafkaDynamicConfig.deleteTopicDynamic(topic);
        return ResponseEntity.ok("Topic " + topic + " delete successfully");
    }
}
