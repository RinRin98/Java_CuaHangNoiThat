package com.example.DoAn_Java_API.services;

import com.example.DoAn_Java_API.model.Role;
import com.example.DoAn_Java_API.model.User;
import com.example.DoAn_Java_API.repository.IRoleRepository;
import com.example.DoAn_Java_API.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;
    public void addUser (User user){
        Role role = roleRepository.getRoleByName("USER");
        user.setRole(role);
        userRepository.save(user);

    }
    public void saveUser (User user){
        Role role = roleRepository.getRoleByName("USER");
        user.setRole(role);
        userRepository.save(user);

    }
    public void updateUser (User user){
        userRepository.save(user);

    }
    public User getUserByNameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
    public User getByUserID(Long id){
        Optional<User> user=userRepository.findById(id);
        return user.orElse(null);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public User getUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
