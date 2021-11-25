package monoMIxFlux;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

public class App {
    public static void main(String[] args) {
        Mono<String> stringMono = Mono.just("Hi Pepito").delayElement(Duration.ofSeconds(2));
        Mono<String> stringMono1 = Mono.just("Hi Mr. Jose").delayElement(Duration.ofSeconds(3));

        Flux<String> mixFlux = Flux.concat(stringMono, stringMono1);
        // We are join two mono for build a flux
        // but is the sum to time
        mixFlux.subscribe(System.out::println);

        try {
            Thread.sleep(6000);
        }catch (InterruptedException exception){
            exception.printStackTrace();
        }
    }
}
