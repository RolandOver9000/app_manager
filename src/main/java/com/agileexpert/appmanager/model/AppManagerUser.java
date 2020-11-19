package com.agileexpert.appmanager.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class AppManagerUser {

    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    @OneToMany(mappedBy = "appManagerUser", cascade = {CascadeType.PERSIST})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ConsoleSettings> consoleSettings;

    @OneToMany(mappedBy = "appManagerUser", cascade = {CascadeType.PERSIST})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Application> applications;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Family userFamily;

    private boolean isUserFamilyHead;

}
