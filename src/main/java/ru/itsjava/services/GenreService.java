package ru.itsjava.services;

import ru.itsjava.domain.Genre;

public interface GenreService {
    void changeGenre(String oldName, String updatedName);

    void printGenre(String name);

    void createGenre(Genre genre);

    Genre getGenreById(long id);

    void deleteGenreById(long id);
}
