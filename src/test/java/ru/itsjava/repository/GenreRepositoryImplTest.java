package ru.itsjava.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import ru.itsjava.domain.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@DataJpaTest
@Import(GenreRepositoryImpl.class)
public class GenreRepositoryImplTest {
    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private GenreRepository genreRepository;

    @Test
    public void shouldHaveCorrectInsert(){
        var comedy = new Genre(4L, "comedy");
        genreRepository.insert(comedy);
        var actualGenre = genreRepository.getById(4L);

        Assertions.assertEquals(comedy, actualGenre);
    }

    @Test
    public void shouldHaveCorrectUpdate(){
        var genre = genreRepository.getById(1L);
        genre.setName("comedy");
        genreRepository.update(genre);
        var actualGenre = genreRepository.getById(1L);

        Assertions.assertEquals("comedy", actualGenre.getName());
    }

    @Test
    public void shouldHaveCorrectDeleteById(){
        genreRepository.deleteById(3L);
        var deleteGenre = genreRepository.getById(3L);

        Assertions.assertNull(deleteGenre);
    }
}
