package com.github.camelnotfemale.coffeemakerremotecontrol.controllers;

import com.github.camelnotfemale.coffeemakerremotecontrol.models.CoffeeType;
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

        return null;
    }

    @PostMapping("/stop")
    public String stop() {

        return null;
    }

    @PostMapping("/make")
    public String make(@RequestParam("coffee") CoffeeType coffeeType) {

        return coffeeType.name();
    }

    @GetMapping
    public String getCafePage() {
        return service.getInfo();
    }
}
