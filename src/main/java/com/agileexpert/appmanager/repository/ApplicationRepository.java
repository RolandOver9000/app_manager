package com.agileexpert.appmanager.repository;

import com.agileexpert.appmanager.model.Application;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplicationRepository  extends JpaRepository<Application, Long> {
}
