package com.ezamora.webfluxdemo.controller;

import com.ezamora.webfluxdemo.dto.MultiplyRequestDto;
import com.ezamora.webfluxdemo.dto.Response;
import com.ezamora.webfluxdemo.service.ReactiveMathService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive")
public class ReactiveMatchController {


  @Autowired
  private ReactiveMathService reactiveMathService;


  @GetMapping("/square/{input}")
  public Mono<Response> findSquare(@PathVariable int input) {
    return this.reactiveMathService.findSquare(input);
  }


  @GetMapping("/table/{input}")
  public Flux<Response> multiplicationTable(@PathVariable int input) {
    return this.reactiveMathService.multiplicationTable(input);
  }

  //Exposing streaming API
  @GetMapping(value = "/table/{input}/stream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
  public Flux<Response> multiplicationTableStream(@PathVariable int input) {
    return this.reactiveMathService.multiplicationTable(input);
  }

  @PostMapping(value = "/square")
  public Mono<Response> multiply(@RequestBody Mono<MultiplyRequestDto> dtoRequest) {
    return this.reactiveMathService.multiply(dtoRequest);
  }


}
