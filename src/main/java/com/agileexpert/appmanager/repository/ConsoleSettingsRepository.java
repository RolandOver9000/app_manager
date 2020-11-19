package com.agileexpert.appmanager.repository;

import com.agileexpert.appmanager.model.ConsoleSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleSettingsRepository extends JpaRepository<ConsoleSettings, Long> {
}
