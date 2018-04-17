package me.musclegeeker.springboot.repository;

import me.musclegeeker.springboot.domain.City;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CityRepository {

    private ConcurrentMap<Long, City> repository = new ConcurrentHashMap<>(16);

    private static final AtomicLong ID_GENERATOR = new AtomicLong(0);

    public Long save(City city) {
        Long id = ID_GENERATOR.incrementAndGet();
        city.setId(id);
        repository.put(id, city);
        return id;
    }

    public Collection<City> findAll() {
        return repository.values();
    }

    public City findCityById(Long id) {
        return repository.get(id);
    }

    public Long update(City city) {
        repository.put(city.getId(), city);
        return city.getId();
    }

    public Long delete(Long id) {
        repository.remove(id);
        return id;
    }
}
