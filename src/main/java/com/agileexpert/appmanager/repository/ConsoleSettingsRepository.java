package com.agileexpert.appmanager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsoleSettingsRepository extends CrudRepository<ConsoleSettingsRepository, Long> {
}
