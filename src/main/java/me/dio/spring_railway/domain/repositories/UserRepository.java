package me.dio.spring_railway.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import me.dio.spring_railway.domain.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
