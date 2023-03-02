package com.yfedyna.dishes.dish.controller;

import com.yfedyna.dishes.dish.dto.DishRequest;
import com.yfedyna.dishes.dish.dto.DishResponse;
import com.yfedyna.dishes.dish.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dish")
@RequiredArgsConstructor
public class DishController {

    private final DishService dishService;
//    private final AuthService authService;

    @PostMapping
    public void addDish(@RequestBody DishRequest dishRequest
//                        @RequestHeader("Authorization") String authHeader
    ) {
//        UserEntity user = authService.getUserEntityByToken(authHeader);
        dishService.createDish(dishRequest);
    }

    @GetMapping("/{id}")
    public DishResponse getDish(@PathVariable Long id){
        return dishService.getDish(id);
    }

    @GetMapping
    public List<DishResponse> getAllDishes(Pageable pageable) {
        return dishService.getAllDishes(pageable);
    }

    @PutMapping("/{id}")
    public DishResponse updateDish(@PathVariable Long id,
                                   @RequestBody DishRequest request
    ) {
        return dishService.updateDish(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteDish(@PathVariable Long id){
//        UserEntity user = authService.getUserEntityByToken(authHeader);
        dishService.deleteDish(id);
    }
}