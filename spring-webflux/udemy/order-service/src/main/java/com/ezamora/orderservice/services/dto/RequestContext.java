package com.ezamora.orderservice.services.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RequestContext {

  private PurchaseOrderRequestDto purchaseOrderRequestDto;
  private ProductDto productDto;
  private  TransactionRequestDto transactionRequestDto;
  private TransactionResponseDto transactionResponseDto;

  public RequestContext(PurchaseOrderRequestDto purchaseOrderRequestDto) {
    this.purchaseOrderRequestDto = purchaseOrderRequestDto;
  }


}
