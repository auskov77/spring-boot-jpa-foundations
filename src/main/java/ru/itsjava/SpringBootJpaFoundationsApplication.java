package ru.itsjava;

import org.h2.tools.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.itsjava.domain.Genre;
import ru.itsjava.repository.FilmRepository;
import ru.itsjava.repository.GenreRepository;

import java.sql.SQLException;

@SpringBootApplication
public class SpringBootJpaFoundationsApplication {

    public static void main(String[] args) throws SQLException {
        ApplicationContext context = SpringApplication.run(SpringBootJpaFoundationsApplication.class, args);

        GenreRepository genreRepository = context.getBean(GenreRepository.class);
        System.out.println("genreRepository.getById(1L) = " + genreRepository.getById(1L));

        Genre genre = new Genre(0L, "western");
        genreRepository.insert(genre);
        System.out.println("genreRepository.getById(3L) = " + genreRepository.getById(3L));


        Genre genre3 = genreRepository.getById(3L);
        genre3.setName("WESTERN");

        genreRepository.update(genre3);

        System.out.println("genreRepository.getById(3L) = " + genreRepository.getById(3L));

        genreRepository.deleteById(3L);
        System.out.println("genreRepository.getById(3L) = " + genreRepository.getById(3L));

        FilmRepository filmRepository = context.getBean(FilmRepository.class);
        System.out.println(filmRepository.findAll());

//        Console.main(args);
    }

}
