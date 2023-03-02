package com.yfedyna.dishes.dish.repository;

import com.yfedyna.dishes.dish.model.Dish;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface DishRepository extends CrudRepository<Dish, Long> {

    Optional<Dish> findByName(String name);

    Page<Dish> findAll(Pageable pageable);

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    boolean existsByName(String name);
}
