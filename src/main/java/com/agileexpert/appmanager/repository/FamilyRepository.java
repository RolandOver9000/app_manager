package com.agileexpert.appmanager.repository;

import com.agileexpert.appmanager.model.Family;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FamilyRepository extends CrudRepository<Family, Long> {
}
