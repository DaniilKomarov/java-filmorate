package ru.yandex.practicum.filmorate.controller;

public class ValidationException extends RuntimeException{
    protected ValidationException(String s){
        super(s);
    }
}
