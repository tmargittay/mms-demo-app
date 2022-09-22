package com.tsystems.mms.demoapp.user.service;
import com.tsystems.mms.demoapp.user.domain.User;
import com.tsystems.mms.demoapp.user.dto.UserInstanceItem;
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
   * @return List of users.
   */
  public List<User> getAll() {
    return userRepository.findAll();
  }

  public UserInstanceItem getUserById(Long id) {
    User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    return new UserInstanceItem(user.getId(), user.getEmail());
  }

  public void createUser(String email) {
    userRepository.save(new User(email));
  }
}
