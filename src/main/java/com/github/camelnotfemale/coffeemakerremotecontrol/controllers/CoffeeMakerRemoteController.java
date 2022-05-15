package com.github.camelnotfemale.coffeemakerremotecontrol.controllers;

import com.github.camelnotfemale.coffeemakerremotecontrol.dto.CoffeeMachineInfo;
import com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee.CoffeeType;
import com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee.Ingredients;
import com.github.camelnotfemale.coffeemakerremotecontrol.services.CoffeeMachineService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coffee-maker")
@Tag(name = "CoffeeMaker", description = "The Coffee Maker API")
@RequiredArgsConstructor
public class CoffeeMakerRemoteController {
    private final CoffeeMachineService service;

    @Operation(summary = "Enable coffee machine")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Starting coffee machine result",
                    content = @Content)
    })
    @PostMapping("/start")
    public String start() {
        return service.start();
    }

    @Operation(summary = "Disable coffee machine")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Stopping coffee machine result",
                    content = @Content)
    })
    @PostMapping("/stop")
    public String stop() {
        return service.stop();
    }

    @Operation(summary = "Make coffee")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Coffee brewing result",
                    content = @Content)
    })
    @PostMapping("/make")
    public String make(@Parameter(description = "type of coffee to make")
                           @RequestParam("coffee") CoffeeType coffeeType) {
        return service.make(coffeeType);
    }

    @Operation(summary = "Coffee machine info")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Coffee brewing result",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CoffeeMachineInfo.class)) })
    })
    @GetMapping("/info")
    public CoffeeMachineInfo getCoffeeMachineInfo() {
        return new CoffeeMachineInfo(service.getInfo());
    }

    @Operation(summary = "Loading ingredients")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Loading ingredients result",
                    content = @Content)
    })
    @PostMapping("/load")
    public String loadIngredients(@Parameter(description = "quantity of ingredients")
                                      @RequestBody Ingredients ingredients) {
        return service.loadIngredients(ingredients);
    }
}
