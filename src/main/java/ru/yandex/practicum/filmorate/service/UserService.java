package ru.yandex.practicum.filmorate.service;


import lombok.extern.slf4j.Slf4j;
import ru.yandex.practicum.filmorate.exception.ValidationException;
import ru.yandex.practicum.filmorate.model.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@Slf4j
public class UserService {
    private List<User> users = new ArrayList<>();
    private int id =0;

    public List<User> getUsers(){
        return users;
    }

    public User createUser(User user){
        validateUser(user);
        id++;
        user.setId(id);
        users.add(user);
        log.info("Create new user{}" + user);

        return user;
    }

    public User updateUser(User user){
        validateUser(user);
        User oldUser = null;
        for (User user2 : users){
            if(user2.getId() == user.getId()) {
                oldUser = user2;
            }
        }
        if (oldUser != null) {
            users.remove(oldUser);
            users.add(user);
            log.info("Update user{}" + user);
            return user;
        }else{
            log.warn("Ошибка айди при попытке обновить пользователя");
            throw new ValidationException("Не верное айди");
        }

    }
    protected static void validateUser(User user){
        if (user.getEmail().isBlank() || !user.getEmail().contains("@") || user.getEmail() == null){
            log.warn("Произошла ошибка валидации");
            throw new ValidationException("Электронная почта не должна быть пустой и должна содержать @");
        }
        if (user.getLogin().isBlank() || user.getLogin().contains(" ") || user.getLogin() == null){
            log.warn("Произошла ошибка валидации");
            throw new ValidationException("Логин не может быть пустым и содержать пробелы");
        }
        if (user.getName()==null){
            user.setName(user.getLogin());
        }else if(user.getName().isBlank()){
            user.setName(user.getLogin());
        }
        if (user.getBirthday().isAfter(LocalDate.now())){
            log.warn("Произошла ошибка валидации");
            throw new ValidationException("Дата рождения не может быть в будущем");
        }
    }
}
