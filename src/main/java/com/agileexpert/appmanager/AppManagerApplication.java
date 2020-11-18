package com.agileexpert.appmanager;

import com.agileexpert.appmanager.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppManagerApplication.class, args);
    }

}
