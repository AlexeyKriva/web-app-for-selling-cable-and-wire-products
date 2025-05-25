package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.URL;

public record UserDetailsUpdateDto (
    @Size(min = 6, max = 55)
    @Pattern(regexp = "^[a-zA-Z0-9_ ]+$")
    String username,

    @Email
    String email,

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z ]+$")
    String firstName,

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z ]+$")
    String lastName,

    @Pattern(regexp = "^(?:\\+375|375|80)(?:25|29|33|44|17)\\d{7}$")
    String phoneNumber,

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z\\s\\-]+$")
    String country,

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z\\s\\-]+$")
    String region,

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z\\s\\-]+$")
    String city,

    @Size(max = 255)
    String street,

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z0-9\\-/]+$")
    String houseNumber,

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z0-9\\-/]+$")
    String apartmentNumber,

    @Size(max = 255)
    @Pattern(regexp = "^[0-9]{4,10}$")
    String zipCode,

    @URL
    String avatarUrl,

    @Size(max = 1000)
    String description
) {}
