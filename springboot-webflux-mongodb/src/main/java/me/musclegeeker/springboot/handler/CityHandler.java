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

    public Mono<City> save(City city) {
        return cityRepository.save(city);
    }

    public Mono<City> findCityById(Long id) {
        return cityRepository.findById(id);
    }

    public Flux<City> findAllCity() {
        return cityRepository.findAll();
    }

    public Mono<City> modifyCity(City city) {
        return cityRepository.save(city);
    }

    public Mono<Long> deleteCity(Long id) {
        cityRepository.deleteById(id);

        return Mono.create(cityMonoSink -> cityMonoSink.success(id));
    }
}
