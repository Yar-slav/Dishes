package com.yfedyna.dishes.dish.service;

import com.yfedyna.dishes.dish.dto.DishRequest;
import com.yfedyna.dishes.dish.dto.DishResponse;
import com.yfedyna.dishes.dish.model.Dish;
import com.yfedyna.dishes.dish.model.DishType;
import com.yfedyna.dishes.dish.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishServiceImpl implements DishService {

    private final DishRepository dishRepository;

    @Transactional
    @Override
    public void createDish(DishRequest dishRequest) {
        checkIfDishExist(dishRequest.getName());
        Dish dish = mapToDish(dishRequest);
        dishRepository.save(dish);
    }

    @Override
    public void deleteDish(Long id) {
        Dish dish = getDishEntity(id);
        dishRepository.deleteById(dish.getId());
    }

    @Override
    public DishResponse getDish(Long id) {
        Dish dish = getDishEntity(id);
        return mapToDishResponse(dish);
    }

    @Override
    public DishResponse updateDish(Long id, DishRequest request) {
        Dish dish = getDishEntity(id);
        return mapToDishResponse(request, dish);
    }

    @Override
    public List<DishResponse> getAllDishes(Pageable pageable) {
        return dishRepository.findAll(pageable)
                .map(DishServiceImpl::mapToDishResponse)
                .toList();
    }

    private static DishResponse mapToDishResponse(DishRequest request, Dish dish) {
        return DishResponse.builder()
                .id(dish.getId())
                .name(request.getName())
                .type(String.valueOf(request.getType()))
                .description(request.getDescription())
                .image(request.getImage())
                .build();
    }

    private static DishResponse mapToDishResponse(Dish dish) {
        return DishResponse.builder()
                .id(dish.getId())
                .name(dish.getName())
                .type(String.valueOf(dish.getType()))
                .description(dish.getDescription())
                .image(dish.getImage())
                .build();
    }

    private static Dish mapToDish(DishRequest dishRequest) {
        return Dish.builder()
                .name(dishRequest.getName())
                .type(DishType.valueOf(dishRequest.getType()))
                .description(dishRequest.getDescription())
                .image(dishRequest.getImage())
                .build();
    }

    private void checkIfDishExist(String name) {
        if(dishRepository.existsByName(name)) {
            throw new ResponseStatusException(HttpStatusCode.valueOf(409), "Dhis with this name already exist");
        }
    }

    private Dish getDishEntity(Long id) {
        return dishRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatusCode.valueOf(404), "Dish not found"));
    }
}
