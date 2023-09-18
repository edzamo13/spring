package com.ezamora.orderservice.services.mapper;

import com.ezamora.orderservice.domain.PurchaseOrder;
import com.ezamora.orderservice.services.dto.PurchaseOrderResponseDto;
import com.ezamora.orderservice.services.dto.RequestContext;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TransactionMapper {

  TransactionMapper INSTANCE = Mappers.getMapper(TransactionMapper.class);

  @Mapping(target = "transactionRequestDto", source = "requestContext.transactionRequestDto")
  RequestContext setTransactionRequestDto(RequestContext requestContext);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "userId", source = "requestContext.purchaseOrderRequestDto.userId")
  @Mapping(target = "productId", source = "requestContext.purchaseOrderRequestDto.productId")
  @Mapping(target = "amount", source = "requestContext.productDto.price")
  @Mapping(target = "status", source = "requestContext.transactionResponseDto.status")
  PurchaseOrder toPurchaseOrder(RequestContext requestContext);


  @Mapping(target = "orderId", source = "purchaseOrder.id")
  PurchaseOrderResponseDto toPurchaseOrderResponseDto(PurchaseOrder purchaseOrder);


}
