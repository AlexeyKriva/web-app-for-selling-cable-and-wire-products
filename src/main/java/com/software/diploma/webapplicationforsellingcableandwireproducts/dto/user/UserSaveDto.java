package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.Role;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserRole;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSaveDto {
    @NotBlank
    @Size(min = 6, max = 55)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String username;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;

    @NotBlank
    @Pattern(regexp = "^(?:\\+375|375|80)(?:25|29|33|44|17)\\d{7}$")
    private String phoneNumber;

    @NotEmpty
    private Set<Role> roles = new HashSet<>();
}
