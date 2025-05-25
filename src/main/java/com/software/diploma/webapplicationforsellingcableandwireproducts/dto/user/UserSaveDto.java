package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.Role;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.Set;

public record UserSaveDto (
    @NotBlank
    @Size(min = 6, max = 55)
    @Pattern(regexp = "^[a-zA-Z0-9_ ]+$")
    String username,

    @Email
    @NotBlank
    String email,

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]+$")
    String firstName,

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z ]+$")
    String lastName,

    @NotBlank
    @Pattern(regexp = "^(?:\\+375|375|80)(?:25|29|33|44|17)\\d{7}$")
    String phoneNumber,

    @NotEmpty
    Set<Role> roles
) {}
