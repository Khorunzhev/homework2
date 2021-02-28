package ru.khorunzhev.otus.homework2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.khorunzhev.otus.homework2.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
