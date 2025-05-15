package com.software.diploma.webapplicationforsellingcableandwireproducts.services.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;

public interface UserService {
    User getByIdAndNotDeleted(Long id);
    User save(User user);
    void deleteById(Long id);
    void applyUserUpdates(User existUser, User updateUser);
    void banById(Long id);
}
