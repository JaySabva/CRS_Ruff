package org.jaysabva.course_registration_system.dto;

public record CourseDto(Long id, String courseName, String courseCode, int courseCredit, Long professorId, Long semesterId, int maxEnrollment, int currentEnrollment) {}
