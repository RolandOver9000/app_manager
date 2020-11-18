package com.agileexpert.appmanager.repository;

import com.agileexpert.appmanager.model.AppManagerUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppManagerUserRepository extends CrudRepository<AppManagerUser, Long> {

    Optional<AppManagerUser> findByUsernameAndPassword(String username, String password);
}
