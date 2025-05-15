package com.software.diploma.webapplicationforsellingcableandwireproducts.repository.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserStats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserStatsRepository extends JpaRepository<UserStats, Long> {
    @Query("SELECT us FROM UserStats us WHERE us.user.id = :userId AND us.user.isDeleted = false")
    Optional<UserStats> findByUserIdAndUserNotDeleted(long userId);
}
