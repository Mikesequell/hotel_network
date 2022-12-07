package com.hotel.projectHotel.prototype;

import com.hotel.projectHotel.model.entity.Role;

public class RolePrototype {
    public static Role getRole() {
        Role role = new Role();
        role.setId(3);
        role.setName("ROLE_TEST");
        return role;
    }
}
