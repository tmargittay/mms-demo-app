package com.tsystems.mms.demoapp.user.service;

import com.tsystems.mms.demoapp.user.domain.OrganisationalUnit;
import com.tsystems.mms.demoapp.user.domain.User;
import com.tsystems.mms.demoapp.user.dto.*;
import com.tsystems.mms.demoapp.user.enums.Gender;
import com.tsystems.mms.demoapp.user.exception.InvalidEmailException;
import com.tsystems.mms.demoapp.user.repository.OrganisationalUnitRepository;
import com.tsystems.mms.demoapp.user.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This service manages all user.
 */
@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;
    private final OrganisationalUnitRepository unitRepository;

    public UserService(UserRepository userRepository, OrganisationalUnitRepository unitRepository) {
        this.userRepository = userRepository;
        this.unitRepository = unitRepository;
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
        return new UserInstanceItem(user);
    }

    public UserInstanceItem createUser(UserCreateCommand command) throws InvalidEmailException {
        User user = null;
        if (isEmailValid(command.getEmail())) {
            user = userRepository.save(new User(command.getEmail(), command.getFirst_name(), command.getSurname(), Gender.valueOf(command.getGender()), null));
        } else {
            throw new InvalidEmailException();
        }
        return new UserInstanceItem(user);
    }

    public UserInstanceItem modifyUser(UserModifyCommand command) throws InvalidEmailException {
        User user = userRepository.findById(command.getId()).orElseThrow(EntityNotFoundException::new);
        if (command.getEmail() != null) {
            if (isEmailValid(command.getEmail())) {
                user.setEmail(command.getEmail());
            } else {
                throw new InvalidEmailException();
            }
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
        if (command.getUnitId() != null) {
            OrganisationalUnit unit = unitRepository.findById(command.getUnitId()).orElseThrow(EntityNotFoundException::new);
            user.setUnit(unit);
        }
        return new UserInstanceItem(user);
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }

    public boolean isEmailValid(String email) {
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public UnitInstanceItem addUserToUnit(UserAddToUnitCommand command) {
        OrganisationalUnit unit = unitRepository.findById(command.getUnitId()).orElseThrow(EntityNotFoundException::new);
        User user = userRepository.findById(command.getId()).orElseThrow(EntityNotFoundException::new);
        unit.getUsers().add(user);
        user.setUnit(unit);
        return new UnitInstanceItem(unit.getUnitId(), unit);
    }
}
