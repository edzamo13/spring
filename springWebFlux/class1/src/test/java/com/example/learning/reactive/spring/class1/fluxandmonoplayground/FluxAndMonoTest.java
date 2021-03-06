package com.example.learning.reactive.spring.class1.fluxandmonoplayground;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class FluxAndMonoTest {

    @Test
    public void fluxTest() {
        Flux<String> stringFlux = Flux.just("Spring", "Spring boot", "Reactive Spring")
              //  .concatWith(Flux.error(new RuntimeException("Exception Occurred")))
                .concatWith(Flux.just("After Error"))
                .log();
        stringFlux
                .subscribe(System.out::println,
                        e -> System.err.println(e),
                        ()-> System.out.println("Completed"));

    }

    @Test
    public void fluxTestElements_WithoutError(){
        Flux<String> stringFlux = Flux.just("Spring", "Spring boot", "Reactive Spring")
                .log();
        StepVerifier.create(stringFlux)
                .expectNext("Spring")
                .expectNext("Spring boot")
                .expectNext("Reactive Spring")
                .verifyComplete();
    }

    @Test
    public void fluxTestElements_WithError(){
        Flux<String> stringFlux = Flux.just("Spring", "Spring boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Occurred")))
                .concatWith(Flux.just("After Error"))
                .log();

        StepVerifier.create(stringFlux)
                .expectNext("Spring")
                .expectNext("Spring boot")
                .expectNext("Reactive Spring")
                //.expectError(RuntimeException.class)
                .expectErrorMessage("Exception Occurred")
                .verify();
    }
    @Test
    public void fluxTestElementsCount_WithError(){
        Flux<String> stringFlux = Flux.just("Spring", "Spring boot", "Reactive Spring")
                .concatWith(Flux.error(new RuntimeException("Exception Occurred")))
                .log();

        StepVerifier.create(stringFlux)
                .expectNextCount(3)
                .expectErrorMessage("Exception Occurred")
                .verify();
    }

    @Test
    public void monoTest(){
        Mono<String> stringMono= Mono.just("Spring")
                .log();

        StepVerifier.create(stringMono)
                .expectNext("Spring")
                .verifyComplete();
    }

    @Test
    public void monoTest_Error(){
        Mono<String> stringMono= Mono.just("Spring")
                .log();

        StepVerifier.create(Mono.error(new RuntimeException("Exception Occurred")))
                .expectError(RuntimeException.class)
                .verify();
    }
}
