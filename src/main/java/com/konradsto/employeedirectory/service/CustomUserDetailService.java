package com.konradsto.employeedirectory.service;

import java.util.Optional;

import com.konradsto.employeedirectory.dao.UserRepository;
import com.konradsto.employeedirectory.model.CustomUserDetails;
import com.konradsto.employeedirectory.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        CustomUserDetails userDetails = null;
        if (user != null) {
            userDetails = new CustomUserDetails(user);
        } else {
            throw new UsernameNotFoundException("User not exist with name : " + username);
        }
        return userDetails;

    }
}
