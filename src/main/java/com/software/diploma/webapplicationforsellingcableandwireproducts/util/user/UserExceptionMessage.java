package com.software.diploma.webapplicationforsellingcableandwireproducts.util.user;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserExceptionMessage {
    public static final String USER_BANNED_MESSAGE = "Access denied: the user account is banned.";
    public static final String DEFAULT_BANNED_REASON_MESSAGE = "Violation of the terms of use.";
    public static final String USER_NOT_FOUND_MESSAGE = "User not found.";
}
