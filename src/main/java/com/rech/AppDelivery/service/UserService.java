package com.rech.AppDelivery.service;

import com.rech.AppDelivery.exceptions.EmailAlreadyInUse;
import com.rech.AppDelivery.exceptions.UserInfoOutOfCompliance;
import com.rech.AppDelivery.model.User;
import com.rech.AppDelivery.repository.UserRepository;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    EmailValidator emailValidator = EmailValidator.getInstance();

    public User saveUser(User userToSave) {
        if (userToSave.getName().length() < 12) {
            throw new UserInfoOutOfCompliance("Name must be at least 12 characters long");
        }
        if (!emailValidator.isValid(userToSave.getEmail())) {
            throw new UserInfoOutOfCompliance("Email format incorrect");
        }
        if (userToSave.getPassword().length() < 6) {
            throw new UserInfoOutOfCompliance("Password length must be at least 6 characters long");
        }
        checkEmailAlreadyInUse(userToSave.getEmail());
        return repository.save(userToSave);
    }

    private void checkEmailAlreadyInUse(String email) {
        Optional<User> user = repository.findByEmail(email);
        if(user.isPresent()) {
            throw new EmailAlreadyInUse("Email already in use");
        }
    }
}
