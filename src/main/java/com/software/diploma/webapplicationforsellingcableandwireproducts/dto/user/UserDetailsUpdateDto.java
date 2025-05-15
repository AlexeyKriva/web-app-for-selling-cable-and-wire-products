package com.software.diploma.webapplicationforsellingcableandwireproducts.dto.user;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsUpdateDto {
    @Size(min = 6, max = 55)
    @Pattern(regexp = "^[a-zA-Z0-9_]+$")
    private String username;

    @Email
    private String email;

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;

    @Pattern(regexp = "^(?:\\+375|375|80)(?:25|29|33|44|17)\\d{7}$")
    private String phoneNumber;

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z\\s\\-]+$")
    private String country;

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z\\s\\-]+$")
    private String region;

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z\\s\\-]+$")
    private String city;

    @Size(max = 255)
    private String street;

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z0-9\\-/]+$")
    private String houseNumber;

    @Size(max = 255)
    @Pattern(regexp = "^[a-zA-Z0-9\\-/]+$")
    private String apartmentNumber;

    @Size(max = 255)
    @Pattern(regexp = "^[0-9]{4,10}$")
    private String zipCode;

    @URL
    private String avatarUrl;

    @Size(max = 1000)
    private String description;
}
