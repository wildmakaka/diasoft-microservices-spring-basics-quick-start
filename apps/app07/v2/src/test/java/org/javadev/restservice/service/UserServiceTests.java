package org.javadev.restservice.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

import org.javadev.restservice.dao.UserRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.javadev.restservice.entity.User;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    User user;

    @Before
    public void setUp() throws Exception {

        MockitoAnnotations.initMocks(this);

        user = new User();
        user.setId(7);
        user.setName("Webmakaka7");
        user.setAddress("Address7");
    }

    @Test
    public void createUserTest() {

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser);
        assertEquals(user.getId(), createdUser.getId());
        assertEquals(user.getName(), createdUser.getName());
        assertEquals(user.getAddress(), createdUser.getAddress());
    }

    @Test
    public void getUserByIdTest() {

        when(userRepository.findById(anyInt())).thenReturn(Optional.ofNullable(user));

        User userFromDB = userService.getUserById(user.getId());

        assertNotNull(userFromDB);
        assertEquals(user.getId(), userFromDB.getId());
        assertEquals(user.getName(), userFromDB.getName());
        assertEquals(user.getAddress(), userFromDB.getAddress());
    }

    @Test
    public void updateUserTest() {

        when(userRepository.findById(anyInt())).thenReturn(Optional.ofNullable(user));

        User newUser = new User();
        newUser.setId(8);
        newUser.setName("Webmakaka8");
        newUser.setAddress("Address8");

        User updatedUser = userService.updateUser(newUser);

        assertNotNull(updatedUser);
        assertEquals(user.getId(), updatedUser.getId());
        assertEquals(newUser.getName(), updatedUser.getName());
        assertEquals(newUser.getAddress(), updatedUser.getAddress());
    }

    @Test
    public void deleteUserByIdTest() {
        String result = userService.deleteUserById(user.getId());
        assertEquals(result, "User deleted!");
    }


} // The End of Class;

