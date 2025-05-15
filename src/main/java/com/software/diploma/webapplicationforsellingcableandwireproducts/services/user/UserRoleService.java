package com.software.diploma.webapplicationforsellingcableandwireproducts.services.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserRole;

import java.util.Set;

public interface UserRoleService {
    Set<UserRole> getByUserId(Long userId);
    UserRole save(UserRole userRole);
}
