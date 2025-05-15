package com.software.diploma.webapplicationforsellingcableandwireproducts.event.user;

import com.software.diploma.webapplicationforsellingcableandwireproducts.entity.user.User;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class SaveUserEvent extends ApplicationEvent {
    private final User user;

    public SaveUserEvent(Object source, User user) {
        super(source);
        this.user = user;
    }
}
