package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.khorunzhev.otus.homework2.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

}
