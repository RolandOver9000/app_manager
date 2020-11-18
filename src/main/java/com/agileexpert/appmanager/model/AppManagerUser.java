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

    @Column(unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "appManagerUser", cascade = {CascadeType.PERSIST})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<ConsoleSettings> consoleSettings;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Family userFamily;

    @Column(nullable = false)
    private boolean isUserFamilyHead;

}
