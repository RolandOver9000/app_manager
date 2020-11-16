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

    private ConsoleSettings consoleSettings;

    @OneToMany(mappedBy = "", cascade = {CascadeType.PERSIST})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<AppManagerUser> familyMembers;

    @Enumerated(EnumType.STRING)
    private FamilyRole familyRole;

}
