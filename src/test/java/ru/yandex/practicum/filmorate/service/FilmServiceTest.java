package ru.yandex.practicum.filmorate.service;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class FilmServiceTest {


    @Test
    void validateFilmTest(){
        final Film film = new Film();
        film.setName("pok");
        film.setDescription("parampam");
        film.setReleaseDate(LocalDate.of(2003,2,15));
        film.setDuration(-100);

        ValidationException exception = assertThrows(ValidationException.class, () -> FilmService.validateFilm(film));
        assertNotNull(exception);
    }
}