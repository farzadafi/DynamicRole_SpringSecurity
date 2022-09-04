package com.example.Spring.reposiroty;

import com.example.Spring.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    @Query
            ("FROM Role AS r join Url AS u ON" +
                    " r.role = :role and" +
                    " u.url = :url")
    Optional<Role> findRoleWithUrl(@Param("role") String role,
                                   @Param("url") String url);
}
