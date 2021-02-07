package io.hieuvanle.travely.server.repository;


import io.hieuvanle.travely.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findUserByUserName(String username);
    Optional<User> findUserByEmail(String email);
}
