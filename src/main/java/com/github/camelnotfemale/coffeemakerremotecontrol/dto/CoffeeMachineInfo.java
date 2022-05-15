package com.github.camelnotfemale.coffeemakerremotecontrol.dto;

import com.github.camelnotfemale.coffeemakerremotecontrol.models.CoffeeMachine;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

@Getter
@Schema(description = "Information about the status of the coffee machine")
public class CoffeeMachineInfo {
    private int milk;
    private int water;
    private int beans;
    private boolean isEnabled;
    private boolean isBusy;

    public CoffeeMachineInfo(CoffeeMachine cm) {
        this.milk = cm.getMilk();
        this.water = cm.getWater();
        this.beans = cm.getBeans();
        this.isEnabled = (cm.getExecutor() != null) ? true : false;
        this.isBusy = cm.getBusy();
    }
}
