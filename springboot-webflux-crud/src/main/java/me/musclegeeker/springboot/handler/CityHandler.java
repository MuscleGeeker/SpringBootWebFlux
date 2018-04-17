package me.musclegeeker.springboot.handler;

import lombok.AllArgsConstructor;
import me.musclegeeker.springboot.domain.City;
import me.musclegeeker.springboot.repository.CityRepository;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@AllArgsConstructor
public class CityHandler {

    private final CityRepository cityRepository;

    public Mono<Long> save(City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.save(city)));
    }

    public Mono<City> findCityById(Long id) {
        return Mono.justOrEmpty(cityRepository.findCityById(id));
    }

    public Flux<City> findAllCity() {
        return Flux.fromIterable(cityRepository.findAll());
    }

    public Mono<Long> modifyCity(City city) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.update(city)));
    }

    public Mono<Long> deleteCity(Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(cityRepository.delete(id)));
    }
}
