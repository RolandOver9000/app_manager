package com.agileexpert.appmanager.model.menuelement;

import com.agileexpert.appmanager.model.menuelement.menunavigationelement.UserManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AppManagerMenu {

    private final UserManager userManager;


}
