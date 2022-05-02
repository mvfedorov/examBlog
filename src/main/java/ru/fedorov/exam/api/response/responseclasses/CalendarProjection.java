package ru.fedorov.exam.api.response.responseclasses;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface CalendarProjection {
    LocalDateTime getDate();
    Integer getPostCount();
}
