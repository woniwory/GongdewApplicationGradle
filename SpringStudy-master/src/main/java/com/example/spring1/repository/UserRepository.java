package com.example.spring1.repository;

import com.example.spring1.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {

    //email 전체 조회
    User findByEmail(String email);

    //로그인 email과 password 조회
    @Query("select u from User u where u.email = :email and u.password= :password")
    User findByEmailAddress(@Param("email") String email,
                            @Param("password") String password);
}

