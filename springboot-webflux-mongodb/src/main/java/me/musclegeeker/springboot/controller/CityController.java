package me.musclegeeker.springboot.controller;

import lombok.AllArgsConstructor;
import me.musclegeeker.springboot.domain.City;
import me.musclegeeker.springboot.handler.CityHandler;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/city")
public class CityController {

    private final CityHandler cityHandler;

    @PostMapping
    public Mono<City> save(@RequestBody City city) {
        return cityHandler.save(city);
    }

    @GetMapping("/{id}")
    public Mono<City> findById(@PathVariable Long id) {
        return cityHandler.findCityById(id);
    }

    @GetMapping
    public Flux<City> findAllCity() {
        return cityHandler.findAllCity();
    }

    @PutMapping
    public Mono<City> modify(@RequestBody City city) {
        return cityHandler.modifyCity(city);
    }

    @DeleteMapping("/{id}")
    public Mono<Long> delete(@PathVariable Long id) {
        return cityHandler.deleteCity(id);
    }
}
