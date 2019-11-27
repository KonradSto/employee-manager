package com.konradsto.employeedirectory.service;

import java.util.List;
import java.util.Optional;

import com.konradsto.employeedirectory.dao.UserRepository;
import com.konradsto.employeedirectory.model.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

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
        userRepository.save(user);
    }

    public void deleteById(int id){
        userRepository.deleteById(id);
    }

    public List<Users> findAll(){
        return userRepository.findAll();
    }
}
