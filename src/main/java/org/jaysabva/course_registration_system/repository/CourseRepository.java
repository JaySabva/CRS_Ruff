package org.jaysabva.course_registration_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.jaysabva.course_registration_system.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
