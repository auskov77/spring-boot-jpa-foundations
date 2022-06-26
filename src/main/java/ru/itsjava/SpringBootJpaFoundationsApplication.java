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
        genreRepository.save(genre);
        System.out.println("genreRepository.getById(3L) = " + genreRepository.getById(3L));


        Genre genre3 = genreRepository.getById(3L);
        genre3.setName("WESTERN");

        genreRepository.save(genre3);

        System.out.println("genreRepository.getById(3L) = " + genreRepository.getById(3L));

        genreRepository.deleteById(3L);
        System.out.println("genreRepository.findById(3L).isPresent() = " + genreRepository.findById(3L).isPresent());

        FilmRepository filmRepository = context.getBean(FilmRepository.class);
        System.out.println(filmRepository.findAll());

//        System.out.println("genreRepository.getByName(\"WESTERN\") = " + genreRepository.getByName("WESTERN"));
//        Console.main(args);

        System.out.println("genreRepository.getByName(\"WESTERN\").isPresent() = " + genreRepository.getByName("WESTERN").isPresent());

        System.out.println("filmRepository.findFilmByTitleAndGenre(\"Harry Potter\", genreRepository.getById(1L)).isPresent() = " +
                filmRepository.findFilmByTitleAndGenre("Harry Potter",
                        genreRepository.getById(1L)).isPresent());
    }

}
