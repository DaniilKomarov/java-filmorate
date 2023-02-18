package ru.yandex.practicum.filmorate.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.filmorate.model.*;
import ru.yandex.practicum.filmorate.service.FilmService;


import java.util.List;

@Slf4j
@RestController
public class FilmController {
    private FilmService filmService = new FilmService();

    @GetMapping("/films")
    public List<Film> findAll(){

        return filmService.getFilms();
    }
    @PostMapping(value = "/films")
    public Film create(@RequestBody Film film){
        return filmService.createFilm(film);
    }
    @PutMapping("/films")
    public Film put(@RequestBody Film film){

         return filmService.updateFilm(film);
    }


}
