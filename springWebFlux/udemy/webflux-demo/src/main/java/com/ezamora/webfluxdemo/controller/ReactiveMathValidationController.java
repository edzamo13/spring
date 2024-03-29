package com.ezamora.webfluxdemo.controller;

import com.ezamora.webfluxdemo.dto.Response;
import com.ezamora.webfluxdemo.exception.InputValidationException;
import com.ezamora.webfluxdemo.service.ReactiveMathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("reactive-math")
public class ReactiveMathValidationController {

  @Autowired
  private ReactiveMathService mathService;

  @GetMapping("square/{input}/throws")
  public Mono<Response> findSquare(@PathVariable int input) {
    if (input < 10 || input > 20) {
      throw new InputValidationException(input);
    }
    return this.mathService.findSquare(input);
  }

  @GetMapping("square/{input}/mono-error")
  public Mono<Response> monoError(@PathVariable int input) {
    return Mono.just(input)
        .handle((integer, synchronousSink) -> {
          if (integer >= 10 && integer <= 20) {
            synchronousSink.next(integer);
          } else {
            synchronousSink.error(new InputValidationException(integer));
          }
        })
        .cast(Integer.class)
        .flatMap(v -> this.mathService.findSquare(v));
  }

  @GetMapping("square/{input}/assignment")
  public Mono<ResponseEntity<Response>> assignment(@PathVariable int input) {
    return Mono.just(input)
        .filter(v -> v >= 10 && v <= 20)
        .flatMap(v -> this.mathService.findSquare(v))
        .map(ResponseEntity::ok)
        .defaultIfEmpty(ResponseEntity.badRequest().build());
  }
}
