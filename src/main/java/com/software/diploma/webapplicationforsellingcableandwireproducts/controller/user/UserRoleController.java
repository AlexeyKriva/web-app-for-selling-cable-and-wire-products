package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserRole;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.user.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping(value = "/api/v1/user-roles", produces = "application/json")
@RequiredArgsConstructor
public class UserRoleController {
    private final UserRoleService service;

    @GetMapping("/{userId}")
    public ResponseEntity<Set<UserRole>> getByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }
}
