package ru.itsjava.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.itsjava.domain.Film;
import ru.itsjava.domain.Genre;
import ru.itsjava.domain.Place;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class FilmDto {
    private String id;
    private String title;
    private String genre;
    private String places;

    public static Film fromDto(FilmDto filmDto) {
        long id = Long.parseLong(filmDto.id);
        Genre genre = new Genre(0L, filmDto.genre);
        String[] splitPlaces = filmDto.places.split(",");

        List<Place> places = new ArrayList<>();
        for (String splitPlace : splitPlaces) {
            places.add(new Place(0L, splitPlace, id));
        }
        return new Film(id, filmDto.title, genre, places);
    }

    public static FilmDto toDto(Film film) {
        String id = String.valueOf(film.getId());
        String title = film.getTitle();
        String genre = film.getGenre().getName();

        StringBuilder stringBuilder = new StringBuilder();
        for (Place place : film.getPlaces()) {
            stringBuilder.append(place.getName()).append(",");
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);

        String places = stringBuilder.toString();

        return new FilmDto(id, title, genre, places);
    }
}
