package ru.yandex.practicum.filmorate;
import ru.yandex.practicum.filmorate.controller.*;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import ru.yandex.practicum.filmorate.controller.FilmController;
import ru.yandex.practicum.filmorate.controller.UserController;
import ru.yandex.practicum.filmorate.controller.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;
import ru.yandex.practicum.filmorate.model.User;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertNotNull;


import java.time.LocalDate;

@SpringBootTest
class FilmorateApplicationTests {

	@Test
	void contextLoads() {
	}



}
