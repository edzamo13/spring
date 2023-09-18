package com.ezamora.orderservice.services;

import com.ezamora.orderservice.services.dto.TransactionRequestDto;
import com.ezamora.orderservice.services.dto.TransactionResponseDto;
import reactor.core.publisher.Mono;

public interface UserClientService {


  Mono<TransactionResponseDto> authorizeTransaction(TransactionRequestDto requestDto);
}
