package com.github.camelnotfemale.coffeemakerremotecontrol.controllers;

import com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee.CoffeeType;
import com.github.camelnotfemale.coffeemakerremotecontrol.services.CoffeeMachineService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffee-maker")
@RequiredArgsConstructor
public class CoffeeMakerRemoteController {
    private final CoffeeMachineService service;

    @PostMapping("/start")
    public String start() {
        return service.start();
    }

    @PostMapping("/stop")
    public String stop() {
        return service.stop();
    }

    @PostMapping("/make")
    public String make(@RequestParam("coffee") CoffeeType coffeeType) {
        return service.make(coffeeType);
    }

    @GetMapping
    public String getCafePage() {
        return service.getInfo();
    }
}
