package com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cappuccino extends Coffee {

    public Cappuccino(@Value("${cappuccino.time-to-make}") int timeToMake,
                      @Value("${cappuccino.milk}") int milk,
                      @Value("${cappuccino.water}") int water,
                      @Value("${cappuccino.beans}") int beans) {
        this.timeToMake = timeToMake;
        this.milk = milk;
        this.water = water;
        this.beans = beans;
    }

    @Override
    public CoffeeType getType() {
        return CoffeeType.CAPPUCCINO;
    }
}
