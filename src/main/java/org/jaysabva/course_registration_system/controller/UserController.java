package org.jaysabva.course_registration_system.controller;

import org.springframework.web.bind.annotation.*;
import org.jaysabva.course_registration_system.dto.UserDto;
import org.jaysabva.course_registration_system.service.UserService;
import org.jaysabva.course_registration_system.dto.SemesterDto;
import org.jaysabva.course_registration_system.dto.CourseDto;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add-professor")
    public String addProfessor(@RequestBody UserDto professor) {
        return userService.addProfessor(professor);
    }

    @PostMapping("/add-student")
    public String addStudent(@RequestBody UserDto student) {
        return userService.addStudent(student);
    }

    @DeleteMapping("/delete-user")
    public String deleteUser(@RequestParam String email) {
        return userService.deleteUser(email);
    }

    @PostMapping("/add-semester")
    public String addSemester(@RequestBody SemesterDto semester) {
        return userService.addSemester(semester);
    }

    @PostMapping("/update-semester/{id}")
    public String updateSemester(@PathVariable Long id, @RequestBody SemesterDto semester) {
        semester = new SemesterDto(id, semester.name(), semester.startDate(), semester.endDate());
        return userService.updateSemester(semester);
    }

    @PostMapping("/add-course")
    public String addCourse(@RequestBody CourseDto course) {
        return userService.addCourse(course);
    }

    @PostMapping("/update-course/{id}")
    public String updateCourse(@PathVariable Long id, @RequestBody CourseDto course) {
        course = new CourseDto(id, course.courseName(), course.courseCode(), course.courseCredit(), course.professorId(), course.semesterId(), course.maxEnrollment(), course.currentEnrollment());
        return userService.updateCourse(course);
    }

    @DeleteMapping("/delete-course/{id}")
    public String deleteCourse(@PathVariable Long id) {
        return userService.deleteCourse(id);
    }

    @GetMapping("/get-course-list")
    public List<Map<String, String>> getCourseList() {
        return userService.getCourseList();
    }

}
