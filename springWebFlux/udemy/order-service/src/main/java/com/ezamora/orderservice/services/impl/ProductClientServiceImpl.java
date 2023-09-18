package com.ezamora.orderservice.services.impl;

import com.ezamora.orderservice.services.ProductClientService;
import com.ezamora.orderservice.services.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductClientServiceImpl implements ProductClientService {

  private final WebClient webClient;


  public ProductClientServiceImpl(@Value("{product.service.url}") String url) {
    this.webClient = WebClient
        .builder()
        .baseUrl(url)
        .build();
  }


  @Override
  public Mono<ProductDto> getProductById(String productId) {
    return this.webClient.get()
        .uri("{id}",productId)
        .retrieve()
        .bodyToMono(ProductDto.class);
  }
}
