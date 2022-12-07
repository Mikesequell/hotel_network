package com.hotel.projectHotel.service.impl;

import com.hotel.projectHotel.dto.UserDto;
import com.hotel.projectHotel.model.repositiry.UserRepository;
import com.hotel.projectHotel.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService, UserService {

    private final UserRepository userRepository;

    @Transactional
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new User(user.getUsername(), user.getPassword(), user.isEnabled(), user.isAccountNonExpired(), user.isCredentialsNonExpired(), user.isAccountNonLocked(), getAuthorities(user));
    }


    private Collection<? extends GrantedAuthority> getAuthorities(com.hotel.projectHotel.model.entity.User user) {
        var authorities = new ArrayList<GrantedAuthority>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return authorities;
    }

    @Override
    public List<UserDto> getAllUsers() {
        log.info("Getting all users");
        var allUsers = userRepository.findAll();
        var usersDto = new ArrayList<UserDto>();
        allUsers.forEach(user -> {
            var userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUsername(user.getUsername());
            usersDto.add(userDto);
        });
        return usersDto;
    }
}
