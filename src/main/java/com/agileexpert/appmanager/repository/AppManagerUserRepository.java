package com.agileexpert.appmanager.repository;

import com.agileexpert.appmanager.model.AppManagerUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppManagerUserRepository extends JpaRepository<AppManagerUser, Long> {

    Optional<AppManagerUser> findByUsernameAndPassword(String username, String password);
}
