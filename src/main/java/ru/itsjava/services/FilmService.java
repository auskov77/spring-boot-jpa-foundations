package ru.itsjava.services;

import org.apache.catalina.LifecycleState;
import ru.itsjava.domain.Film;

import java.util.List;

public interface FilmService {
    void printAllFilms();
    List<Film> getAllFilms();
}
