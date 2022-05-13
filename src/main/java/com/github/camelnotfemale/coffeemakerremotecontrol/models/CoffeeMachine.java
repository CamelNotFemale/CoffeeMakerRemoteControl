package com.github.camelnotfemale.coffeemakerremotecontrol.models;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@Getter
@ToString
public class CoffeeMachine {
    private int milk;
    private int water;
    private int beans;

    public CoffeeMachine(@Value("${machine.milk}") int milk,
                         @Value("${machine.water}") int water,
                         @Value("${machine.beans}") int beans) {
        this.milk = milk;
        this.water = water;
        this.beans = beans;
    }
}
