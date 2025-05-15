package com.software.diploma.webapplicationforsellingcableandwireproducts.services.impl.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;
import com.software.diploma.webapplicationforsellingcableandwireproducts.event.user.SaveUserEvent;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.user.UserBannedException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.user.UserNotFoundException;
import com.software.diploma.webapplicationforsellingcableandwireproducts.repository.user.UserRepository;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.user.UserExceptionMessage.USER_BANNED_MESSAGE;
import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.user.UserExceptionMessage.USER_NOT_FOUND_MESSAGE;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final ApplicationEventPublisher publisher;

    @Transactional(readOnly = true)
    public User getByIdAndNotDeleted(Long id) {
        User user = repository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> {
                    throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE);
                });

        if (!user.isBanned()) {
            return user;
        }

        throw new UserBannedException(USER_BANNED_MESSAGE);
    }

    @Transactional
    public User save(User newUser) {
        User savedUser = repository.save(newUser);

        publisher.publishEvent(new SaveUserEvent(this, savedUser));

        return savedUser;
    }

    @Transactional
    public void deleteById(Long id) {
        User existUser = repository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> {
            throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE);
        });

        if (!existUser.isBanned()) {
            existUser.setDeleted(true);

            repository.save(existUser);

            return;
        }

        throw new UserBannedException(USER_BANNED_MESSAGE);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void applyUserUpdates(User existUser, User updateUser) {
        if (updateUser.getUsername() != null) {
            existUser.setUsername(updateUser.getUsername());
        }

        if (updateUser.getFirstName() != null) {
            existUser.setFirstName(updateUser.getFirstName());
        }

        if (updateUser.getLastName() != null) {
            existUser.setLastName(updateUser.getLastName());
        }

        if (updateUser.getEmail() != null) {
            existUser.setEmail(updateUser.getEmail());
        }

        if (updateUser.getPhoneNumber() != null) {
            existUser.setPhoneNumber(updateUser.getPhoneNumber());
        }

        if (updateUser.getAddress() != null) {
            existUser.setAddress(updateUser.getAddress());
        }

        repository.save(existUser);
    }

    @Transactional
    public void banById(Long id) {
        User existUser = repository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> {
            throw new UserNotFoundException(USER_NOT_FOUND_MESSAGE);
        });


        if (!existUser.isBanned()) {
            existUser.setBanned(true);

            repository.save(existUser);

            return;
        }

        throw new UserBannedException(USER_BANNED_MESSAGE);
    }
}
