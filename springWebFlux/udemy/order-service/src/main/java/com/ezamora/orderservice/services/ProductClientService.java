package com.ezamora.orderservice.services;

import com.ezamora.orderservice.services.dto.ProductDto;
import reactor.core.publisher.Mono;

public interface ProductClientService {


  Mono<ProductDto> getProductById(String productId);
}
