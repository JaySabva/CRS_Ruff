package org.jaysabva.course_registration_system.repository;

import org.jaysabva.course_registration_system.entity.Semester;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemesterRepository extends JpaRepository<Semester, Long> {
}
