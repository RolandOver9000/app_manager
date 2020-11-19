package com.agileexpert.appmanager.service.dataaccess;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.model.Family;
import com.agileexpert.appmanager.repository.FamilyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class FamilyService {

    private final FamilyRepository familyRepository;

    public Family createNewFamily(Family family) {
       return familyRepository.save(family);
    }

    public Family getFamilyByFamilyHead(AppManagerUser familyHead) {
        Optional<Family> searchedFamily = familyRepository.getByFamilyHead(familyHead);
        return searchedFamily.orElse(null);
    }

    public Family getNewFamilyObject() {
        return Family.builder()
                .build();
    }
}
