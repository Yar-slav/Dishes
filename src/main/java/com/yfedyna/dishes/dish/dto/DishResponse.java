package com.yfedyna.dishes.dish.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DishResponse {
    private Long id;
    private String name;
    private String type;
    private String description;
    private String image;
}
