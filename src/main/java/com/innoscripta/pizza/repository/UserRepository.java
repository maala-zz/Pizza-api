package com.innoscripta.pizza.repository;

import com.innoscripta.pizza.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {

    @Query("SELECT u FROM User u WHERE u.email like :email and u.password like :password")
    User findUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("SELECT u FROM User u WHERE u.id like :id")
    User findUserById(@Param("id") UUID userId);

    @Query("SELECT u FROM User u WHERE u.email like :email")
    User findUserByEmail(@Param("email") String email);

}
