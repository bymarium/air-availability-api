package com.airsofka.authentication.infra.mysql.repositories;


import com.airsofka.authentication.infra.mysql.entities.UserSql;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IUserRepository extends JpaRepository<UserSql, String> {
  Optional<UserSql> findByEmail(String email);
}
