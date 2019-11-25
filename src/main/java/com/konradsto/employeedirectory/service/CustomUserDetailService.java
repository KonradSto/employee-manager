package com.konradsto.employeedirectory.service;

import com.konradsto.employeedirectory.dao.UserRepository;
import com.konradsto.employeedirectory.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        CustomUserDetails userDetails = null;
        if(user != null){
            userDetails = new CustomUserDetails();
            userDetails.setEmployee(user);
        } else {
            throw new UsernameNotFoundException("Username " + username + "does not exist.");
        }
        return null;
    }
}