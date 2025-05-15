package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserRole;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.user.UserRoleRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.user.UserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements UserRoleService {
    private final UserRoleRepository repository;

    @Transactional(readOnly = true)
    public Set<UserRole> getByUserId(Long userId) {
        return repository.findAllByUserId(userId);
    }

    @Transactional
    public UserRole save(UserRole userRole) {
        return repository.save(userRole);
    }
}
