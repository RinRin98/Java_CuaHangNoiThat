package com.example.DoAn_Java_API.repository;

import com.example.DoAn_Java_API.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    @Query("SELECT r.idRole FROM Role r WHERE r.roleName = ?1")
    Long getRoleIdByName(String roleName);
    @Query("SELECT r FROM Role r WHERE r.roleName = ?1")
    Role getRoleByName(String roleName);

}
