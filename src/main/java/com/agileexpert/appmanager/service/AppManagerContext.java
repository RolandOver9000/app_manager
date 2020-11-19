package com.agileexpert.appmanager.service;

import com.agileexpert.appmanager.model.AppManagerUser;
import com.agileexpert.appmanager.model.ConsoleSettings;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AppManagerContext {

    private AppManagerUser currentAppManagerUser;
    private ConsoleSettings currentConsoleSettings;

}
