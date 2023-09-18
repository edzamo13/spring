package com.ezamora.orderservice.services.impl;

import com.ezamora.orderservice.services.UserClientService;
import com.ezamora.orderservice.services.dto.TransactionRequestDto;
import com.ezamora.orderservice.services.dto.TransactionResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserClientServiceImp implements UserClientService {

  private final WebClient webClient;


  private UserClientServiceImp(@Value("{user.service.url}") String url) {
    this.webClient = WebClient.builder()
        .baseUrl(url)
        .build();
  }

  @Override
  public Mono<TransactionResponseDto> authorizeTransaction(TransactionRequestDto requestDto) {
    return this.webClient.post()
        .uri("transaction")
        .bodyValue(requestDto)
        .retrieve()
        .bodyToMono(TransactionResponseDto.class);
  }


}
