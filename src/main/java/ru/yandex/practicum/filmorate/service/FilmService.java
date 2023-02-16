package ru.yandex.practicum.filmorate.service;


import lombok.extern.slf4j.Slf4j;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.Film;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class FilmService {
    private List<Film> films = new ArrayList<>();
    private int id;

    public List<Film> getFilms(){
        return films;
    }
    public Film createFilm(Film film){
        validateFilm(film);
        id++;
        film.setId(id);
        films.add(film);
        log.info("Create new film{}" + film);
        return film;
    }

    public Film updateFilm(Film film){
        validateFilm(film);
        Film oldFilm = null;
        for (Film film2 : films){
            if(film2.getId() == film.getId()) {
                oldFilm = film2;
            }
        }
        if (oldFilm != null) {
            films.remove(oldFilm);
            films.add(film);
            log.info("Update film{}" + film);
            return film;

        }else{
            log.warn("Ошибка айди при попытке обновить фильм");
            throw new ValidationException("Не верное айди");
        }
    }
    protected static void validateFilm(Film film){
        if (film.getName().isBlank() || film.getName() == null){
            log.warn("Произошла ошибка валидации");
            throw new ValidationException("Название фильма не может быть пустым");
        }
        if (film.getDescription().length()>200){
            log.warn("Произошла ошибка валидации");
            throw new ValidationException("Описание не может быть длинее 200 символов");
        }
        if (film.getDuration() <0 ){
            log.warn("Произошла ошибка валидации");
            throw new ValidationException("Продолжительность должна быть не отрицательной");
        }
        if (film.getReleaseDate().isBefore(LocalDate.of(1895, 12,28))){
            log.warn("Произошла ошибка валидации");
            throw new ValidationException("Дата релиза не может быть раньше - 28 декабря 1895");
        }
    }

}
