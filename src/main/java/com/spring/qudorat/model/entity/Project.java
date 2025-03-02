package com.spring.qudorat.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String projectName;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "project")
    private List<Test> tests;
}
