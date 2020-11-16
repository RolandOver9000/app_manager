package com.agileexpert.appmanager.model;


import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Family {

    @Id
    @GeneratedValue
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private AppManagerUser familyHead;

    @OneToMany(mappedBy = "userFamily", cascade = {CascadeType.PERSIST})
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<AppManagerUser> familyMembers;
}
