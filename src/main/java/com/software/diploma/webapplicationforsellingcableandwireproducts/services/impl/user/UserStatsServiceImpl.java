package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserStats;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.user.UserBannedException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.user.UserNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.user.UserStatsRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.user.UserStatsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.user.UserExceptionMessage.USER_BANNED_MESSAGE;
import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.user.UserExceptionMessage.USER_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class UserStatsServiceImpl implements UserStatsService {
    private final UserStatsRepository repository;

    @Transactional(readOnly = true)
    public UserStats getByUserId(Long userId) {
        UserStats existUserStats = repository.findByUserIdAndUserNotDeleted(userId)
                .orElseThrow(() -> {
                    throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE);
                });

        if (!existUserStats.getUser().isBanned()) {
            return existUserStats;
        }

        throw new UserBannedException(USER_BANNED_MESSAGE);
    }

    public UserStats save(UserStats userStats) {
        return repository.save(userStats);
    }

}
