package com.agileexpert.appmanager.service.dataaccess;

import com.agileexpert.appmanager.model.Application;
import com.agileexpert.appmanager.repository.ApplicationRepository;
import com.agileexpert.appmanager.service.AppManagerContext;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Service
@RequiredArgsConstructor
@Slf4j
public class ApplicationService{

    private final ApplicationRepository applicationRepository;
    private final AppManagerContext appManagerContext;


    public List<Application> getInstalledApplications() {
        initSomeApplications();
        return applicationRepository
                .findByAppManagerUser(appManagerContext.getCurrentAppManagerUser());
    }

    private void initSomeApplications() {
        Application application1 = Application.builder()
                .applicationName("Tinder")
                .appManagerUser(appManagerContext.getCurrentAppManagerUser())
                .applicationPath("/app/tinder")
                .build();
        
        Application application2 = Application.builder()
                .applicationName("BeHealthy")
                .appManagerUser(appManagerContext.getCurrentAppManagerUser())
                .applicationPath("/app/behealthy")
                .build();

        Application application3 = Application.builder()
                .applicationName("RandomGame")
                .appManagerUser(appManagerContext.getCurrentAppManagerUser())
                .applicationPath("/app/randomgame")
                .build();

        applicationRepository.saveAll(Arrays.asList(application1, application2, application3));
    }
}
