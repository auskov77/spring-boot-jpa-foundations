package ru.itsjava.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.itsjava.domain.Film;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class FilmRepositoryImpl implements FilmRepository {
    private final EntityManager entityManager;

    @Override
    public List<Film> findAll() {
        return entityManager
                .createQuery("select distinct f from films f join fetch f.genre join fetch f.places", Film.class)
                .getResultList();
    }
}
