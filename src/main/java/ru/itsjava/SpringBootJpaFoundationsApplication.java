package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.domain.Genre;
import ru.itsjava.repository.FilmRepository;
import ru.itsjava.repository.GenreRepository;
import ru.itsjava.services.FilmService;
import ru.itsjava.services.GenreService;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBootJpaFoundationsApplication {

    public static void main(String[] args) throws SQLException {
        var context = SpringApplication.run(SpringBootJpaFoundationsApplication.class, args);
        FilmService filmService = context.getBean(FilmService.class);
        filmService.printAllFilms();

        GenreService genreService = context.getBean(GenreService.class);
        genreService.changeGenre("fantasy", "comedy");
        genreService.printGenre("comedy");
    }

}
