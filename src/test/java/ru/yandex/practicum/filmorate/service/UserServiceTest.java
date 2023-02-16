package ru.yandex.practicum.filmorate.service;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.controller.UserController;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Test
    void validateUserTest(){
        final User user = new User();
        user.setEmail("23sa");
        user.setLogin("ghdoe");
        user.setName("232");
        user.setBirthday(LocalDate.of(2030,12,2));
        ValidationException exception = assertThrows(ValidationException.class, () -> UserService.validateUser(user));
        assertNotNull(exception);
    }
}