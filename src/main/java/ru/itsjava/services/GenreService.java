package ru.itsjava.services;

import ru.itsjava.domain.Genre;

import java.util.List;

public interface GenreService {
    void changeGenre(String oldName, String updatedName);

    void printGenre(String name);

    void createGenre(Genre genre);

    Genre getGenreById(long id);

    void deleteGenre(Genre genre);

    List<Genre> getAllGenres();

    void updateGenre(Genre genre);
}
