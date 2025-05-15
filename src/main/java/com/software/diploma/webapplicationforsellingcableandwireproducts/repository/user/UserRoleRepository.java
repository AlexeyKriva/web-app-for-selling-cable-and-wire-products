package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    Set<UserRole> findAllByUserId(Long userId);
}
