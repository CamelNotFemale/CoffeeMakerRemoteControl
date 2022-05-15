package com.github.camelnotfemale.coffeemakerremotecontrol.models;

import com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee.Coffee;
import com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee.Ingredients;
import com.github.camelnotfemale.coffeemakerremotecontrol.util.CustomLog;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;

@Component
@Scope("singleton")
@ToString
@Getter
@Slf4j
public class CoffeeMachine {
    @ToString.Exclude
    @Getter(value = AccessLevel.PRIVATE)
    private final ObjectFactory<ExecutorService> executorsFactory;

    private int milk;
    private int water;
    private int beans;
    private volatile Boolean busy;
    @ToString.Exclude
    private ExecutorService executor;

    public CoffeeMachine(ObjectFactory<ExecutorService> executorsFactory,
                         @Value("${machine.milk}") int milk,
                         @Value("${machine.water}") int water,
                         @Value("${machine.beans}") int beans) {
        this.executorsFactory= executorsFactory;
        this.milk = milk;
        this.water = water;
        this.beans = beans;
        this.busy = false;
    }

    @CustomLog
    public String turnOn() {
        if (executor != null) {
            return "Coffee machine is already on";
        }
        executor = executorsFactory.getObject();
        this.busy = false;
        return "Coffee machine turned on";
    }

    @CustomLog
    public String turnOff() {
        if (executor == null) {
            return "Coffee machine is already off";
        }
        executor.shutdownNow();
        executor = null;
        this.busy = false;
        return "Coffee machine turned off";
    }

    private boolean processing(int millis) {
        try {
            Thread.sleep(millis);
            busy = false;
            return true;
        } catch (InterruptedException ie) {
            busy = false;
            Thread.currentThread().interrupt();
        }
        return false;
    }

    @CustomLog
    public String make(Coffee coffee) {
        if (executor == null || executor.isShutdown()) return "The coffee machine is off";
        if (busy) return "The coffee machine is already making coffee";
        synchronized (busy = true) {
            if (!isEnoughIngredients(coffee)) {
                busy = false;
                return String.format("Not enough ingredients for %s", coffee.getType());
            }
            loadIngredients(coffee);
            executor.submit(() -> processing(coffee.getTimeToMake()));
            return String.format("The coffee machine started to make %s", coffee.getType());
        }
    }

    public boolean isEnoughIngredients(Coffee coffee) {
        if (this.milk < coffee.getMilk() || this.water < coffee.getWater() || this.beans < coffee.getBeans()) {
            return false;
        }
        return true;
    }

    private void loadIngredients(Coffee coffee) {
        this.milk -= coffee.getMilk();
        this.water -= coffee.getWater();
        this.beans -= coffee.getBeans();
    }

    @CustomLog
    public String addIngredients(Ingredients ingredients) {
        if (busy) return "The coffee machine is already making coffee";
        synchronized (busy = true) {
            this.milk += ingredients.getMilk();
            this.water += ingredients.getWater();
            this.beans += ingredients.getBeans();
            executorsFactory.getObject().submit(() -> processing(10000));
            return "Adding Ingredients";
        }
    }
}
