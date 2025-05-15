package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {
    @Query("SELECT ud FROM UserDetails ud WHERE ud.user.id = :userId AND ud.user.isDeleted = false")
    Optional<UserDetails> findByUserIdAndUserNotDeleted(long userId);
}
