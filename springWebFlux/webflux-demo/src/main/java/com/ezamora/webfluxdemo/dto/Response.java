package com.ezamora.webfluxdemo.dto;

import java.util.Date;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Response {

  private Date date = new Date();
  private int outPut;

  public Response(int outPut) {
    this.outPut = outPut;
  }

}
