package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.user.UserDetailsUpdateDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserDetails;
import com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.user.UserDetailsMapper;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.user.UserDetailsService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user-details", produces = "application/json")
@RequiredArgsConstructor
public class UserDetailsController {
    private final UserDetailsMapper mapper = UserDetailsMapper.INSTANCE;
    private final UserDetailsService service;

    @GetMapping("/{userId}")
    public ResponseEntity<UserDetails> getByUserId(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(service.getByUserId(userId));
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<UserDetails> updateByUserId(@PathVariable("userId") Long userId,
                                                      @Valid @RequestBody UserDetailsUpdateDto updateDto) {
        return ResponseEntity.ok(service.updateByUserId(userId,
                mapper.toUserDetails(updateDto)));
    }

    @GetMapping
    public ResponseEntity<List<UserDetails>> getAllByIsDeleted() {
        return ResponseEntity.ok(service.getAll());
    }
}
