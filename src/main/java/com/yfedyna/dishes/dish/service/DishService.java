package com.yfedyna.dishes.dish.service;

import com.yfedyna.dishes.dish.dto.DishRequest;
import com.yfedyna.dishes.dish.dto.DishResponse;
import com.yfedyna.dishes.user.model.UserEntity;
import com.yfedyna.dishes.user.service.AuthService;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DishService {
    void createDish(DishRequest dishRequest);

    void deleteDish(Long id);

    DishResponse getDish(Long id);

    DishResponse updateDish(Long id, DishRequest request);

    List<DishResponse> getAllDishes(Pageable pageable);
}
