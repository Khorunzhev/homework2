package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.stereotype.Repository;
import ru.khorunzhev.otus.homework2.model.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class GenreRepositoryJpaImpl implements GenreRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Genre getByName(String name) {
        TypedQuery<Genre> query = em.createQuery("select g " +
                        "from Genre g " +
                        "where g.name = :name",
                Genre.class);
        query.setParameter("name", name);
        return query.getResultList()
                .stream()
                .findFirst()
                .orElse(null);
    }

    @Override
    public Genre insert(Genre name) {
        if (name.getId() <= 0) {
            em.persist(name);
            return name;
        } else {
            return em.merge(name);
        }
    }
}
