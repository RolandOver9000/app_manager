package com.agileexpert.appmanager.repository;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.model.Family;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FamilyRepository extends JpaRepository<Family, Long> {

    Optional<Family> getByFamilyHead(AppManagerUser appManagerUser);

}
