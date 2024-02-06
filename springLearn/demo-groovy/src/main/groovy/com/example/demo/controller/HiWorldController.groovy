package com.example.demo.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/greeting")
class HiWorldController {

    @GetMapping
    def String greeting() {
        return "Never give up to learning "
    }

}



