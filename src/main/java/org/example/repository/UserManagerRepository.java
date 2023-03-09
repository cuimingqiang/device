package org.example.repository;

import org.example.model.user.UserManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagerRepository extends JpaRepository<UserManager, Long> {

    UserManager findUserByAccountAndPassword(String account, String password);
}
