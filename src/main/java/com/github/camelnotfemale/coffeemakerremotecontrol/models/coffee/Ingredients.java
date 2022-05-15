package com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@Schema(description = "Quantity of ingredients")
public class Ingredients {
    @Min(0)
    @NotBlank
    protected int milk;
    @Min(0)
    @NotBlank
    protected int water;
    @Min(0)
    @NotBlank
    protected int beans;
}
