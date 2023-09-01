package com.ezamora.webfluxdemo.service;

import com.ezamora.webfluxdemo.dto.Response;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReactiveMathService {


  public Mono<Response> findSquare(int input) {
    return Mono.fromSupplier(() -> {
          System.out.println("input: " + input);
          return input * input;
        })
        .map(Response::new);
  }

  public Flux<Response> multiplicationTable(int input) {
    return Flux.range(1, 10)
        .doOnNext(i -> SleepUtil.sleepSeconds(1))
        .doOnNext(i -> System.out.println("reactive-math-service processing :" + i))
        .map(m -> new Response(input * input));
  }
}