package com.tsystems.mms.demoapp.user.service;

import com.tsystems.mms.demoapp.user.domain.User;
import com.tsystems.mms.demoapp.user.dto.UserCreateCommand;
import com.tsystems.mms.demoapp.user.dto.UserInstanceItem;
import com.tsystems.mms.demoapp.user.dto.UserModifyCommand;
import com.tsystems.mms.demoapp.user.enums.Gender;
import com.tsystems.mms.demoapp.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

/**
 * This service manages all user.
 */
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Find all users from the database.
     *
     * @return List of users.
     */
    public List<User> getAll() {
        return userRepository.findAll();
    }

    public UserInstanceItem getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return new UserInstanceItem(user.getId(), user.getEmail(), user.getFirst_name(), user.getSurname(), user.getGender().toString());
    }

    public UserInstanceItem createUser(UserCreateCommand command) {
        User user = userRepository.save(new User(command.getEmail(), command.getFirst_name(), command.getSurname(), Gender.valueOf(command.getGender())));
        return new UserInstanceItem(user.getId(), user.getEmail(), user.getFirst_name(), user.getSurname(), user.getGender().toString());
    }

    public UserInstanceItem modifyUser(UserModifyCommand command) {
        User user = userRepository.findById(command.getId()).orElseThrow(EntityNotFoundException::new);
        if (command.getEmail() != null) {
            user.setEmail(command.getEmail());
        }
        if (command.getFirst_name() != null) {
            user.setFirst_name(command.getFirst_name());
        }
        if (command.getSurname() != null) {
            user.setSurname(command.getSurname());
        }
        if (command.getGender() != null) {
            user.setGender(Gender.valueOf(command.getGender()));
        }
        return new UserInstanceItem(user.getId(), user.getEmail(), user.getFirst_name(), user.getSurname(), user.getGender().toString());
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
