package com.example.stream.cloud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Procedure {

  private final KafkaTemplate template;

  public void send(String phrase){
    template.sendDefault(phrase);
  }

}
