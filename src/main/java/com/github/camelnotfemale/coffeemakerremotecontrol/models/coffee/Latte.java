package com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Latte extends Coffee {

    public Latte(@Value("${latte.time-to-make}") int timeToMake,
                      @Value("${latte.milk}") int milk,
                      @Value("${latte.water}") int water,
                      @Value("${latte.beans}") int beans) {
        this.timeToMake = timeToMake;
        this.milk = milk;
        this.water = water;
        this.beans = beans;
    }

    @Override
    public CoffeeType getType() {
        return CoffeeType.LATTE;
    }
}