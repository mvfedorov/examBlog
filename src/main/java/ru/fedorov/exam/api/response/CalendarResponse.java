package ru.fedorov.exam.api.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CalendarResponse {
    private Integer[] years;
    private Map<String, Integer> posts;
}
