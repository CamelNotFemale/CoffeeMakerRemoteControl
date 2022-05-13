package com.github.camelnotfemale.coffeemakerremotecontrol.services;

import com.github.camelnotfemale.coffeemakerremotecontrol.models.Coffee;
import com.github.camelnotfemale.coffeemakerremotecontrol.models.CoffeeMachine;
import com.github.camelnotfemale.coffeemakerremotecontrol.models.CoffeeType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CoffeeMachineService {
    private final CoffeeMachine coffeeMachine;
    private final Map<CoffeeType, Coffee> coffeeFactory;

    
    public String getInfo() {

        return coffeeFactory + ", " + coffeeMachine;
    }
}
