package com.github.camelnotfemale.coffeemakerremotecontrol.services;

import com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee.Coffee;
import com.github.camelnotfemale.coffeemakerremotecontrol.models.CoffeeMachine;
import com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee.CoffeeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CoffeeMachineService {
    private final CoffeeMachine coffeeMachine;
    private final Map<CoffeeType, Coffee> coffeeFactory;

    public String start() {
        return coffeeMachine.turnOn();
    }

    public String stop() {
        return coffeeMachine.turnOff();
    }

    public String make(CoffeeType coffeeType) {
        return coffeeMachine.make(coffeeFactory.get(coffeeType));
    }

    public String getInfo() {
        return coffeeFactory + ", " + coffeeMachine;
    }
}
