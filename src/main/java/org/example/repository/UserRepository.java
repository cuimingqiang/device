package org.example.repository;

import org.example.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByAccountAndPassword(String account,String password);
}
