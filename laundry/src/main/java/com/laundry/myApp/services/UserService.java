package com.laundry.myApp.services;

import com.laundry.myApp.controllers.form.RegistrationFormDto;
import com.laundry.myApp.models.Role;
import com.laundry.myApp.models.User;
import com.laundry.myApp.repository.UserRepository;
import com.laundry.myApp.services.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getByUsername(String username) throws UserNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException(username));
    }

    public List<User> getByRole(Role role) {
        return userRepository
                .findAll()
                .stream()
                .filter(u -> u.getRoles().contains(role))
                .collect(Collectors.toList());
    }

    public void register(RegistrationFormDto registrationForm) {
        User toRegister = toUser(registrationForm);
        userRepository.save(toRegister);
    }

    private User toUser(RegistrationFormDto registrationForm) {
        Role role = new Role();
        role.setRole("COSTUMER");

        User user = new User();
        user.setName(registrationForm.getName());
        user.setEmail(registrationForm.getEmail());
        user.setPassword(registrationForm.getPassword());
        user.setBirthDate(registrationForm.getBirthDate());
        user.setUsername(registrationForm.getUsername());
        user.addRole(role);
        user.setEnabled(true);

        return user;
    }
}
