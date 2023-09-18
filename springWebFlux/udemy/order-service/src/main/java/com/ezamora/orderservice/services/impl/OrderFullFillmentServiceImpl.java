package com.ezamora.orderservice.services.impl;

import com.ezamora.orderservice.repository.impl.PurchaseOrderRepository;
import com.ezamora.orderservice.services.ProductClientService;
import com.ezamora.orderservice.services.UserClientService;
import com.ezamora.orderservice.services.dto.PurchaseOrderRequestDto;
import com.ezamora.orderservice.services.dto.PurchaseOrderResponseDto;
import com.ezamora.orderservice.services.dto.RequestContext;
import com.ezamora.orderservice.services.mapper.TransactionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class OrderFullFillmentServiceImpl {

  private final ProductClientService productClientService;
  private final UserClientService userClientService;
  private final PurchaseOrderRepository purchaseOrderRepository;


  public Mono<PurchaseOrderResponseDto> processOrder(Mono<PurchaseOrderRequestDto> requestDtoMono) {
    return requestDtoMono.map(RequestContext::new)
        .flatMap(this::productRequestResponse)
        .doOnNext(TransactionMapper.INSTANCE::setTransactionRequestDto)
        .flatMap(this::userRequestResponse)
        .map(TransactionMapper.INSTANCE::toPurchaseOrder)
        .map(this.purchaseOrderRepository::save)//blocking
        .map(TransactionMapper.INSTANCE::toPurchaseOrderResponseDto)
        .subscribeOn(Schedulers.boundedElastic());


  }

  private Mono<RequestContext> productRequestResponse(RequestContext requestContext) {
    return this.productClientService
        .getProductById(requestContext.getPurchaseOrderRequestDto().getProductId())
        .doOnNext(requestContext::setProductDto)
        .doOnNext(
            productDto -> System.out.println("productRequestResponse productDto: " + productDto))
        .thenReturn(requestContext);
  }

  private Mono<RequestContext> userRequestResponse(RequestContext requestContext) {
    return this.userClientService
        .authorizeTransaction(requestContext.getTransactionRequestDto())
        .doOnNext(requestContext::setTransactionResponseDto)
        .thenReturn(requestContext);
  }

}
