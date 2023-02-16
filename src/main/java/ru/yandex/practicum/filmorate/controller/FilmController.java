package ru.yandex.practicum.filmorate.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class FilmController {
    private List<Film> films = new ArrayList<>();
    private int id;

    @GetMapping("/films")
    public List<Film> getFilms(){
        return films;
    }
    @PostMapping(value = "/films")
    public Film createFilm(@RequestBody Film film){
        validateFilm(film);
        id++;
        film.setId(id);
        films.add(film);
        log.info("Create new film{}" + film);
        return film;
    }
    @PutMapping("/films")
    public Film updateFilm(@RequestBody Film film){
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
