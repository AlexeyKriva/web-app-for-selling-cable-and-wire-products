package com.software.diploma.webapplicationforsellingcableandwireproducts.event.user;


import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class UpdateUserDetailsEvent extends ApplicationEvent {
    private User existUser;
    private User updateUser;

    public UpdateUserDetailsEvent(Object source, User existUser, User updateUser) {
        super(source);
        this.existUser = existUser;
        this.updateUser = updateUser;
    }
}
