package com.yfedyna.dishes.user.dto;

import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class ValidationTokenDto {
    private Set<String> roles;
    private Long userId;
}
