package com.example.demo.services;

import com.example.demo.entities.Users;
import com.example.demo.repos.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    public Users saveOneUser(Users newUser) {
        return userRepository.save(newUser);
    }

    public Users getOneUserBy(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public Users updateOneUser(Long userId, Users newUser) {
        Optional<Users> existingUserOptional = userRepository.findById(userId);
        if (existingUserOptional.isPresent()) {
            Users existingUser = existingUserOptional.get();
            existingUser.setName(newUser.getName());
            existingUser.setSurname(newUser.getSurname());
            existingUser.setEmail(newUser.getEmail());
            existingUser.setUserName(newUser.getUserName());
            existingUser.setPassword(newUser.getPassword());

            return userRepository.save(existingUser);
        } else {
            System.out.println("kullanıcı bulınamadı");
            return null;
        }
    }

    public void deleteById(Long userId) {

        userRepository.deleteById(userId);
    }
}
