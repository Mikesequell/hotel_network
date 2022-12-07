package com.hotel.projectHotel.prototype;

import com.hotel.projectHotel.model.entity.Role;
import com.hotel.projectHotel.model.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UsersPrototype {

    public static User getUser() {
        User user = new User();
        user.setUsername("test");

        List<Role> userRoles = new ArrayList<>();
        userRoles.add(RolePrototype.getRole());
        user.setRoles(userRoles);
        return user;
    }
}
