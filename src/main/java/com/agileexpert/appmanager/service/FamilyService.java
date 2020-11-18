package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.model.Family;
import com.agileexpert.appmanager.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class FamilyService {

    private final FamilyRepository familyRepository;

    public Family createNewFamily(Family family) {
       return familyRepository.save(family);
    }

}
