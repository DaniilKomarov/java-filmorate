package ru.yandex.practicum.filmorate.controller;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class UserControllerTest {
    @Test
    void validateUserTest(){
        final User user = new User();
        user.setEmail("23sa");
        user.setLogin("ghdoe");
        user.setName("232");
        user.setBirthday(LocalDate.of(2030,12,2));
        ValidationException exception = assertThrows(ValidationException.class, () -> UserController.validateUser(user));
        assertNotNull(exception);
    }

}