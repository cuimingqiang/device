package org.example.repository;

import org.example.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByAccountAndPassword(String account,String password);

    @Query("SELECT T FROM User T WHERE account = :account")
    User findUserByAccount(String account);

    @Query("UPDATE User SET deviceFingerprint = NULL WHERE account = :deviceAccount AND password = :devicePassword")
    void unbind(String deviceAccount, String devicePassword);
}
