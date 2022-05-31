package com.example.securityproject.repository;

import com.example.securityproject.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,String> {
    @Query("select u from User u where u.username =:username")
    User findUserByUserName(@Param("username") String username);

    @Query("select u from User u where u.userId =:userId")
    User findUserByUserId(@Param("userId") String userId);


}
