package io.hieuvanle.travely.server.repository;


import io.hieuvanle.travely.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
