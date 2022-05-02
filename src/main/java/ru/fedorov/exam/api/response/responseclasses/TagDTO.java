package ru.fedorov.exam.api.response.responseclasses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagDTO {

    public TagDTO(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    private String name;
    private double weight;
}
