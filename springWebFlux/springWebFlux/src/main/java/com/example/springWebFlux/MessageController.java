package com.example.springWebFlux;


import com.example.springWebFlux.entity.Movie;
import com.example.springWebFlux.service.HiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class MessageController {

    @Autowired
    private HiService service;

    @RequestMapping("/hi")
    public Flux<String> getMessage() {
        return service.hola();
    }

    @RequestMapping("/getAllMovies")
    public Flux<Movie> finAllMovies() {
        service.finAllMovies().subscribe(System.out::println);
        return service.finAllMovies();
    }

}
