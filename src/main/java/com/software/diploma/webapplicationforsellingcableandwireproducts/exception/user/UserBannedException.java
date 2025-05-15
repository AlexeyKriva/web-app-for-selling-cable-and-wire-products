package com.software.diploma.webapplicationforsellingcableandwireproducts.exception.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.exception.ApplicationException;
import lombok.Getter;

import static com.software.diploma.webapplicationforsellingcableandwireproducts.util.user.UserExceptionMessage.DEFAULT_BANNED_REASON_MESSAGE;

@Getter
public class UserBannedException extends ApplicationException {
    private String reason = DEFAULT_BANNED_REASON_MESSAGE;

    public UserBannedException(String message) {
        super(message);
    }

    public UserBannedException(String message, String reason) {
        super(message);
        this.reason = reason;
    }
}
