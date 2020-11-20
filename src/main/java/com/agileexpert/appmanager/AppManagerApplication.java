package com.agileexpert.appmanager;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.model.Family;
import com.agileexpert.appmanager.repository.AppManagerUserRepository;
import com.agileexpert.appmanager.repository.FamilyRepository;
import com.agileexpert.appmanager.service.menuinitializer.AuthenticationMenuInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@SpringBootApplication
public class AppManagerApplication {

    @Autowired
    AppManagerUserRepository appManagerUserRepository;

    @Autowired
    FamilyRepository familyRepository;

    @Autowired
    AuthenticationMenuInitializer authenticationMenuInitializer;

    public static void main(String[] args) {
        SpringApplication.run(AppManagerApplication.class, args);
    }


    @Bean
    @Profile("inmemorydb")
    public CommandLineRunner init() {
        return args -> {
            AppManagerUser hambi = AppManagerUser.builder()
                    .username("Hambi123")
                    .password("321imbaH")
                    .isUserFamilyHead(true)
                    .build();

            AppManagerUser hambi2 = AppManagerUser.builder()
                    .username("Hambi222")
                    .password("222imbaH")
                    .isUserFamilyHead(false)
                    .build();

            AppManagerUser hambi3 = AppManagerUser.builder()
                    .username("Hambi333")
                    .password("333imbaH")
                    .isUserFamilyHead(true)
                    .build();


            Family hambiFamily = Family.builder()
                    .familyMember(hambi)
                    .familyMember(hambi2)
                    .familyHead(hambi)
                    .build();
            Family anotherHambiFamily = Family.builder()
                    .familyMember(hambi3)
                    .familyHead(hambi3)
                    .build();

            hambi.setUserFamily(hambiFamily);
            hambi2.setUserFamily(hambiFamily);
            hambi3.setUserFamily(anotherHambiFamily);


            appManagerUserRepository.saveAll(Arrays.asList(hambi, hambi2, hambi3));
            familyRepository.saveAll(Arrays.asList(hambiFamily, anotherHambiFamily));

            authenticationMenuInitializer.initialize();
            authenticationMenuInitializer.linkMenuElements();
            authenticationMenuInitializer.getMenuElement().handleMenuInteraction();
        };
    }


}
