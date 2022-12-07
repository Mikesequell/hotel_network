package com.hotel.projectHotel.prototype;

import com.hotel.projectHotel.model.entity.User;

public class UsersPrototype {

    public static User getUser() {
        User user = new User();
        user.setUsername("test");
        user.setAccountNonExpired(true);
        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        return user;
    }
}
