package com.coursework.bookshop.security.service;

import com.coursework.bookshop.security.entity.CustomUserDetails;
import com.coursework.bookshop.user.entity.Role;
import com.coursework.bookshop.user.entity.User;
import com.coursework.bookshop.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserDetailsServiceConfig implements UserDetailsService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUser(username);
        if (user.getRole().equals(Role.UNKNOWN)){
            throw new UsernameNotFoundException(String.format("Cant find user by [%s]", username));
        }
        return CustomUserDetails.builder()
                .id(user.getId())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .role(mapRolesToGrantedAuthorities(user.getRole()))
                .build();
    }
    private Collection<SimpleGrantedAuthority> mapRolesToGrantedAuthorities(Role role){
        return Stream.of(role).map(r->new SimpleGrantedAuthority(r.toString())).collect(Collectors.toList());
    }
}
