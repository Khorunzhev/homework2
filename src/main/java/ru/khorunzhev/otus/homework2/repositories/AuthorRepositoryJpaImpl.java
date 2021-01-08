package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.stereotype.Repository;
import ru.khorunzhev.otus.homework2.model.Author;
import ru.khorunzhev.otus.homework2.model.Genre;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Repository
public class AuthorRepositoryJpaImpl implements AuthorRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Author getByFullName(String fullName) {
        TypedQuery<Author> query = em.createQuery("select a " +
                        "from Author a " +
                        "where a.fullName = :fullName",
                Author.class);
        query.setParameter("fullName", fullName);
        return query.getSingleResult();
    }
}
