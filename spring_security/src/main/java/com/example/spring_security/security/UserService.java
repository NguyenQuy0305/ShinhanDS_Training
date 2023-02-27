package com.example.spring_security.security;

import com.example.spring_security.entity.User;
import com.example.spring_security.repository.UserReporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserReporitory userReporitory;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userReporitory.findByUsername(username);
        if(user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new CustomUserDetails(user);
    }

    public UserDetails loadUserByUserId(Long userId) throws UsernameNotFoundException {
        Optional<User> user = userReporitory.findById(userId);
        if(!user.isPresent()) {
            throw new UsernameNotFoundException("Long" + userId);
        }
        return new CustomUserDetails(user.get());
    }
}
