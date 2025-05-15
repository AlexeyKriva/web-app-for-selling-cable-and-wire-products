package com.software.diploma.webapplicationforsellingcableandwireproducts.controller.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.dto.user.UserSaveDto;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;
import com.software.diploma.webapplicationforsellingcableandwireproducts.mapper.user.UserMapper;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/users", produces = "application/json")
@RequiredArgsConstructor
public class UserController {
    private final UserMapper mapper = UserMapper.INSTANCE;
    private final UserService service;

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.getByIdAndNotDeleted(id));
    }

    @PostMapping
    public ResponseEntity<User> save(@Valid @RequestBody UserSaveDto userSaveDto) {
        return new ResponseEntity<>(service.save(mapper.toUser(userSaveDto)),
                HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/ban")
    public ResponseEntity<Void> banById(@PathVariable("id") Long id) {
        service.banById(id);
        return ResponseEntity.noContent().build();
    }
}
