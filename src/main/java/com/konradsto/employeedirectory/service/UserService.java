package com.konradsto.employeedirectory.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import com.konradsto.employeedirectory.dao.RoleRepository;
import com.konradsto.employeedirectory.dao.UserRepository;
import com.konradsto.employeedirectory.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Users getUser(int id){
        Optional<Users> employee = userRepository.findById(id);

        Users theUser = null;

        if (employee.isPresent()){
            theUser = employee.get();
        }
        return theUser;
    }

    public void saveUser(Users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setRoles(new HashSet<>(roleRepository.findAll()));
        userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public List<Users> findAll(){
        return userRepository.findAll();
    }
}
