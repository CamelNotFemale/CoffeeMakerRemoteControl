package com.github.camelnotfemale.coffeemakerremotecontrol.models;

import lombok.Getter;

@Getter
public abstract class Coffee {
    protected int timeToMake;
    protected int milk;
    protected int water;
    protected int beans;

    public abstract CoffeeType getType();
}
