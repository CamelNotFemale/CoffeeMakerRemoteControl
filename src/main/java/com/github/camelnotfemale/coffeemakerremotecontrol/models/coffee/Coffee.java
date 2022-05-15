package com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee;

import lombok.Getter;

@Getter
public abstract class Coffee extends Ingredients {
    protected int timeToMake;

    public abstract CoffeeType getType();
}
