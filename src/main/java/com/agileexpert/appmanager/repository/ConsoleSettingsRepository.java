package com.agileexpert.appmanager.repository;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.model.ConsoleSettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ConsoleSettingsRepository extends JpaRepository<ConsoleSettings, Long> {

    Optional<ConsoleSettings> getConsoleSettingsByAppManagerUser(AppManagerUser appManagerUser);
}
