package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserStats;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.user.UserStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/user-stats", produces = "application/json")
@RequiredArgsConstructor
public class UserStatsController {
    private final UserStatsService service;

    @GetMapping("/{userId}")
    public ResponseEntity<UserStats> getById(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }
}
