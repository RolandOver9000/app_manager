package com.agileexpert.appmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class ConsoleSettings {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL})
    private AppManagerUser appManagerUser;

    private String icon;

    private String consoleBackgroundColor;
}
