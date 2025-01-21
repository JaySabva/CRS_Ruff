package org.jaysabva.course_registration_system.dto;

import java.time.LocalDate;
public record SemesterDto (Long id, String name, String startDate, String endDate) {
}
