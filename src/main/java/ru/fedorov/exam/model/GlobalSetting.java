package ru.fedorov.exam.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "global_settings")
public class GlobalSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code;
    private String name;
    private String value;
}
