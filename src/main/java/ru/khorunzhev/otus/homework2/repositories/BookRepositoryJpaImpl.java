package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.stereotype.Repository;
import ru.khorunzhev.otus.homework2.model.Book;
import ru.khorunzhev.otus.homework2.model.Comment;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Repository
public class BookRepositoryJpaImpl implements BookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public int count() {
        Query query = em.createQuery("select count(b) from Book b");
        return query.getFirstResult();
    }

    @Override
    public Book insert(Book book) {
        if (book.getId() <= 0) {
            em.persist(book);
            return book;
        } else {
            return em.merge(book);
        }
    }

    @Override
    public void update(Book book) {
        em.merge(book);
    }

    @Override
    public Optional<Book> getFullInfoById(long id) {
        return Optional.ofNullable(em.find(Book.class, id));
    }

    @Override
    public Book getFullInfoByTitle(String title) {
        TypedQuery<Book> query = em.createQuery("select b " +
                        "from Book b join fetch b.author join fetch b.genre " +
                        "where b.title = :title",
                Book.class);
        query.setParameter("title", title);
        return query.getSingleResult();
    }

    @Override
    public List<Book> getAllFullInfo() {
        TypedQuery<Book> query = em.createQuery("select b from Book b join fetch b.author join fetch b.genre", Book.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(long id) {
        Query query = em.createQuery("delete " +
                "from Book b " +
                "where b.id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Override
    public void delete(Book book) {
        em.remove(book);
    }
}
