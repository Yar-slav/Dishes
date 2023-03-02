package com.yfedyna.dishes.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRegistrationRequest {

    private String firstName;
    private String lastName;
    @Min(value = 1, message = "Age should be one or greater")
    private Integer age;

    @Email(
            regexp = "^(?=.{1,64}@)[A-Za-z0-9+_-]+(\\.[A-Za-z0-9+_-]+)*@[^-][A-Za-z0-9+-]+(\\.[A-Za-z0-9+-]+)*(\\.[A-Za-z]{2,})$",
            message = "Invalid email, please, try again")
    private String email;

    @NotBlank(message = "Password can't be null or whitespace")
    private String password;
}
