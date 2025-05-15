package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserDetails;
import com.software.diploma.webapplicationforsellingcableandwireproducts.event.user.UpdateUserDetailsEvent;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.user.UserBannedException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.user.UserNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.user.UserDetailsRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.user.UserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.user.UserExceptionMessage.USER_BANNED_MESSAGE;
import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.user.UserExceptionMessage.USER_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserDetailsRepository repository;
    private final ApplicationEventPublisher publisher;

    @Transactional(readOnly = true)
    public UserDetails getByUserId(Long userId) {
        UserDetails existUserDetails = repository.findByUserIdAndUserNotDeleted(userId)
                .orElseThrow(() -> {
                    throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE);
                });

        if (!existUserDetails.getUser().isBanned()) {
            return existUserDetails;
        }

        throw new UserBannedException(USER_BANNED_MESSAGE);
    }


    @Transactional
    public UserDetails save(UserDetails userDetails) {
        return repository.save(userDetails);
    }

    @Transactional
    public UserDetails updateByUserId(Long userId, UserDetails updateUserDetails) {
        UserDetails existUserDetails = repository.findByUserIdAndUserNotDeleted(userId)
                .orElseThrow(() -> {
                    throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE);
                });

        if (!existUserDetails.getUser().isBanned()) {
            User existUser = existUserDetails.getUser();

            publisher.publishEvent(new UpdateUserDetailsEvent(this, existUser, updateUserDetails.getUser()));

            if (updateUserDetails.getAvatarUrl() != null) {
                existUserDetails.setAvatarUrl(updateUserDetails.getAvatarUrl());
            }

            if (updateUserDetails.getDescription() != null) {
                existUserDetails.setDescription(updateUserDetails.getDescription());
            }

            return repository.save(existUserDetails);
        }

        throw new UserBannedException(USER_BANNED_MESSAGE);
    }

    @Transactional(readOnly = true)
    public List<UserDetails> getAll() {
        return repository.findAll();
    }
}
