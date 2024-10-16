package com.ezamora.orderservice.domain;

import com.ezamora.orderservice.domain.enums.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class PurchaseOrder {

  @Id
  @GeneratedValue
  private Integer id;
  private String productId;
  private Integer userId;
  private Integer amount;
  private OrderStatus status;
}
