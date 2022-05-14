package com.github.camelnotfemale.coffeemakerremotecontrol.config;

import com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee.Coffee;
import com.github.camelnotfemale.coffeemakerremotecontrol.models.coffee.CoffeeType;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Configuration
@PropertySource("classpath:recipes.properties")
public class AppConfig {

    @Bean
    public Map<CoffeeType, Coffee> coffeeFactory(List<Coffee> coffeeList) {
        return coffeeList.stream().collect(Collectors.toMap(Coffee::getType, coffee -> coffee));
    }

    @Bean
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ExecutorService executorsFactory() {
        return Executors.newSingleThreadExecutor();
    }
}
