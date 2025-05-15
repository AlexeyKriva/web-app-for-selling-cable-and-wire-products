package com.software.diploma.webapplicationforsellingcableandwireproducts.event.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserDetails;
import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserStats;
import com.software.diploma.webapplicationforsellingcableandwireproducts.services.user.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class UserEventListener {
    private final UserService userService;
    private final UserDetailsService userDetailsService;
    private final UserStatsService userStatsService;
    private final UserRoleService userRoleService;
    private final AddressService addressService;

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void saveUserEvent(SaveUserEvent event) {
        User user = event.getUser();

        user.getUserRoles().stream()
                .map(userRole -> {
                    userRole.setUserId(user.getId());
                    return userRole;
                })
                .forEach(userRoleService::save);
        userDetailsService.save(new UserDetails(user));
        userStatsService.save(new UserStats(user));
    }

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    public void updateUserDetails(UpdateUserDetailsEvent event) {
        User existUser = event.getExistUser();
        User updateUser = event.getUpdateUser();

        //addressService.applyAddressUpdates(existUser.getAddress(), updateUser.getAddress());
        userService.applyUserUpdates(existUser, updateUser);
    }
}
