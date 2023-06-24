package com.example.DoAn_Java_API.repository;

import com.example.DoAn_Java_API.model.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsername(String username);
//    @Modifying
//    @Transactional
//    @Query(value = "INSERT INTO user_role (user_id, role_id) " + "VALUES (?1, ?2)", nativeQuery = true)
//    void addRoleToUser(Long userId, Long roleId);

    @Query("SELECT c FROM User c WHERE c.email = ?1")
    User findByEmail(String email);
    @Query("SELECT u.id FROM User u WHERE u.username = ?1")
    Long getUserIdByUserName(String username);

    @Query(value = "SELECT r.role_name FROM role r INNER JOIN user u ON r.id_role = u.id_role WHERE u.id = ?1", nativeQuery = true)
    String []  getRoleOfUser(Long userId);
    public User findByUsernameAndPassword(String username, String password);
}
