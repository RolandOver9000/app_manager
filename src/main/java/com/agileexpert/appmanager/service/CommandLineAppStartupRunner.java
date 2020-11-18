package com.agileexpert.appmanager.service;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommandLineAppStartupRunner implements CommandLineRunner {

    private final MenuService menuService;

    @Override
    public void run(String...args) throws Exception {
        menuService.startAppManagerApplication();
    }
}
