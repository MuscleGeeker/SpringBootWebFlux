package me.musclegeeker.springboot.webflux.controller;

import lombok.AllArgsConstructor;
import me.musclegeeker.springboot.domain.City;
import me.musclegeeker.springboot.handler.CityHandler;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/city")
@AllArgsConstructor
public class CityController {
    private final CityHandler cityHandler;

    @GetMapping(value = "/get/{id}")
    public Mono<City> findCityById(@PathVariable("id") Long id) {
        return cityHandler.findCityById(id);
    }

    @GetMapping
    public Flux<City> findAllCity() {
        return cityHandler.findAllCity();
    }

    @PostMapping
    public Mono<Long> saveCity(@RequestBody City city) {
        return cityHandler.save(city);
    }

    @PutMapping
    public Mono<Long> modifyCity(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping(value = "/delete/{id}")
    public Mono<Long> deleteCity(@PathVariable Long id) {
        return cityHandler.deleteCity(id);
    }
}
