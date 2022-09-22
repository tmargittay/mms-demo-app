package com.tsystems.mms.demoapp.user;

import com.tsystems.mms.demoapp.user.domain.User;
import com.tsystems.mms.demoapp.user.enums.Gender;
import com.tsystems.mms.demoapp.user.repository.OrganisationalUnitRepository;
import com.tsystems.mms.demoapp.user.repository.UserRepository;
import com.tsystems.mms.demoapp.user.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UserServiceTest {

  @MockBean
  private UserRepository userRepository;
  @MockBean
  private OrganisationalUnitRepository unitRepository;

  private UserService userService;
  private List<User> testUsers;

  @BeforeEach
  public void setup() {
    userService = new UserService(userRepository, unitRepository);
    testUsers = new ArrayList<>();
    testUsers.add(createUser(1L,"test1.user@foo.bar"));
    testUsers.add(createUser(2L,"test2.user@foo.bar"));
    testUsers.add(createUser(3L,"test3.user@foo.bar"));
  }

  @Test
  void testGetAll () {
    // Mock
    Mockito.when(userRepository.findAll()).thenReturn(testUsers);

    // Assert
    List<User> users = userService.getAll();
    Assertions.assertNotNull(users);
    Assertions.assertEquals(3, users.size());
    Assertions.assertEquals(testUsers.get(0), users.get(0));

    // Verify
    Mockito.verify(userRepository, Mockito.atMostOnce()).findAll();

  }

  @Test
  void testEmailValidation(){
    User user1good = new User(1L,"test1@gmail.com","Tomi","Margittay", Gender.MALE,null);
    User user2good = new User(2L,"test2@gmail.com","Tomi","Margittay", Gender.MALE,null);
    User user3wrong = new User(3L,"test3gmail.com","Tomi","Margittay", Gender.MALE,null);
    User user4wrong = new User(4L,"test4@gmailcom","Tomi","Margittay", Gender.MALE,null);

    Assertions.assertTrue(userService.isEmailValid(user1good.getEmail()));
    Assertions.assertTrue(userService.isEmailValid(user2good.getEmail()));
    Assertions.assertFalse(userService.isEmailValid(user3wrong.getEmail()));
    Assertions.assertFalse(userService.isEmailValid(user4wrong.getEmail()));
  }
  private User createUser(Long id, String email) {
    User user = new User();
    user.setId(id);
    user.setEmail(email);
    return user;
  }
}
