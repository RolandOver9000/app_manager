package com.agileexpert.appmanager.repository;

import com.agileexpert.appmanager.model.ConsoleSettings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleSettingsRepository extends CrudRepository<ConsoleSettings, Long> {
}
