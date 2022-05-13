package com.github.camelnotfemale.coffeemakerremotecontrol.config;

import com.github.camelnotfemale.coffeemakerremotecontrol.models.Coffee;
import com.github.camelnotfemale.coffeemakerremotecontrol.models.CoffeeType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Configuration
@PropertySource("classpath:recipes.properties")
public class AppConfig {

    @Bean
    public Map<CoffeeType, Coffee> coffeeFactory(List<Coffee> coffeeList) {
        return coffeeList.stream().collect(Collectors.toMap(Coffee::getType, coffee -> coffee));
    }
}
