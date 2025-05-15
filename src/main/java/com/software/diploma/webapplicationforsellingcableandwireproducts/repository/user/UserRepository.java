package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByIdAndIsDeletedFalse(Long id);
}
