package org.example.repository;

import jakarta.transaction.Transactional;
import org.example.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {

    User findUserByAccountAndPassword(String account,String password);

    @Query("SELECT T FROM User T WHERE account = :account")
    User findUserByAccount(String account);

    @Query("SELECT T FROM User T WHERE (account LIKE  CONCAT('%',:account,'%')  OR :account IS NULL)")
    List<User> findAll(String account);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User SET deviceFingerprint = NULL WHERE account = :deviceAccount AND password = :devicePassword")
    void unbind(String deviceAccount, String devicePassword);
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("UPDATE User SET deviceFingerprint = NULL WHERE id = :id")
    void unbind(Long id);
}
