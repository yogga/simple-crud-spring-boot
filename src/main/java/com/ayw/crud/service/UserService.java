package com.ayw.crud.service;

import com.ayw.crud.entity.User;
import com.ayw.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // save
    public User saveUser(User user){
       return userRepository.save(user);
    }

    // find by id
    public User findById(int id){
        Optional<User> user = userRepository.findById(id);

        if(user.isEmpty()){
            throw  new RuntimeException("User not found");
        }
        return user.get();
    }

    // find all
    public List<User> findAll(){
        return userRepository.findAll();

    }

    // update user
    public User updateUser(User user){
        Optional<User> dbuser = userRepository.findById(user.getId());
        if(dbuser.isEmpty()){
            throw new RuntimeException("User not found");
        }
        User existingUser = dbuser.get();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        existingUser.setEmail(user.getEmail());
        return userRepository.save(existingUser);
    }

    // delete user
    public void deleteUser(int id){
        Optional<User> dbuser = userRepository.findById(id);
        if(dbuser.isEmpty()){
            throw new RuntimeException("User not found");
        }
        userRepository.delete(dbuser.get());
    }

}
