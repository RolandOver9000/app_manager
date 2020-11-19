package com.agileexpert.appmanager.repository;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationRepository  extends JpaRepository<Application, Long> {

    Optional<Application> findByAppManagerUser(AppManagerUser appManagerUser);

}
