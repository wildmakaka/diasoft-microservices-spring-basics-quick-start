package org.javadev.restservice.service;

// import org.javadev.restservice.service.UserService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;

import org.javadev.restservice.dao.UserRepository;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.javadev.restservice.entity.User;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTests {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;

    User user;


    @Before
    public void setUp() throws Exception {

        System.out.println("BeforeEach");

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
    public void createUserTest() {

        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser);
        assertEquals(user.getId(), createdUser.getId());
        assertEquals(user.getName(), createdUser.getName());
        assertEquals(user.getAddress(), createdUser.getAddress());
    }

} // The End of Class;

