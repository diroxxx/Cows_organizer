package com.example.cows.Repositories;

import com.example.cows.models.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserPerson, Long> {
//    Optional<UserPerson> findByEmail(String email);
@Query("SELECT u FROM UserPerson u WHERE LOWER(u.email) = LOWER(:email)")
Optional<UserPerson> findByEmail(@Param("email") String email);


}
