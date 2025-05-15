package com.software.diploma.webapplicationforsellingcableandwireproducts.services.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.UserDetails;

import java.util.List;

public interface UserDetailsService {
    UserDetails getByUserId(Long userId);
    UserDetails save(UserDetails userDetails);
    UserDetails updateByUserId(Long userId, UserDetails userDetails);
    List<UserDetails> getAll();
}
