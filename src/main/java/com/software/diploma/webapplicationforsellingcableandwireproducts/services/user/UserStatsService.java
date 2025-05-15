package com.software.diploma.webapplicationforsellingcableandwireproducts.services.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserStats;

public interface UserStatsService {
    UserStats getByUserId(Long userId);
    UserStats save(UserStats userStats);
}
