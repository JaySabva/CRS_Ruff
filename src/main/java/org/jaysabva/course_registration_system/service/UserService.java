package org.jaysabva.course_registration_system.service;

import java.util.List;
import java.util.Map;

import org.jaysabva.course_registration_system.dto.UserDto;
import org.jaysabva.course_registration_system.dto.SemesterDto;
import org.jaysabva.course_registration_system.entity.User;
import org.jaysabva.course_registration_system.dto.CourseDto;

public interface UserService {

    User findByEmail(String email);

    String addProfessor(UserDto professor);

    String addStudent(UserDto student);

    String deleteUser(String email);

    String addSemester(SemesterDto semester);

    String updateSemester(SemesterDto semester);

    String addCourse(CourseDto course);

    String updateCourse(CourseDto course);

    String deleteCourse(Long id);

    List<Map<String, String>> getCourseList();
}
