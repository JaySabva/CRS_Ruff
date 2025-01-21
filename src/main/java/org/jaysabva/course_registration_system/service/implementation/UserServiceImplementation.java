package org.jaysabva.course_registration_system.service.implementation;

import org.jaysabva.course_registration_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jaysabva.course_registration_system.mapper.UserMapper;
import org.jaysabva.course_registration_system.entity.User;
import org.jaysabva.course_registration_system.dto.UserDto;
import org.jaysabva.course_registration_system.dto.SemesterDto;
import org.jaysabva.course_registration_system.repository.UserRepository;
import org.jaysabva.course_registration_system.entity.Semester;
import java.time.LocalDate;
import org.jaysabva.course_registration_system.repository.SemesterRepository;
import org.jaysabva.course_registration_system.repository.CourseRepository;
import org.jaysabva.course_registration_system.dto.CourseDto;
import org.jaysabva.course_registration_system.entity.Course;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class UserServiceImplementation implements UserService{

    private UserRepository userRepository;
    private SemesterRepository semesterRepository;
    private CourseRepository courseRepository;

    @Autowired
    public UserServiceImplementation(UserRepository userRepository, SemesterRepository semesterRepository, CourseRepository courseRepository) {
        this.userRepository = userRepository;
        this.semesterRepository = semesterRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public String addProfessor(UserDto professor) {
        User professorEntity = new User(
            professor.id(),
            professor.name(),
            professor.email(),
            "professor",
            professor.password()
        );
        userRepository.save(professorEntity);
        return "Professor added successfully";
    }

    @Override
    public String addStudent(UserDto student) {
        User studentEntity = new User(
            student.id(),
            student.name(),
            student.email(),
            "student",
            student.password()
        );
        userRepository.save(studentEntity);
        return "Student added successfully";
    }

    @Override
    public String deleteUser(String email) {
        if (userRepository.findByEmail(email) == null) {
            return "User not found";
        }
        userRepository.deleteByEmail(email);
        return "User deleted successfully";
    }

    @Override
    public String addSemester(SemesterDto semesterDto) {
        Semester semester = new Semester(
            semesterDto.id(),
            semesterDto.name(),
            LocalDate.parse(semesterDto.startDate()), // Use LocalDate.parse()
            LocalDate.parse(semesterDto.endDate()),
            "active"
        );
        semesterRepository.save(semester);
        return "Semester added successfully";
    }

    @Override
    public String updateSemester(SemesterDto semesterDto) {
        Semester semester = semesterRepository.findById(semesterDto.id()).orElse(null);
        if (semester == null) {
            return "Semester not found";
        }

        semester.setName(semesterDto.name());
        semester.setStartDate(LocalDate.parse(semesterDto.startDate()));
        semester.setEndDate(LocalDate.parse(semesterDto.endDate()));

        semesterRepository.save(semester);

        return "Semester updated successfully";
    }

    @Override
    public String addCourse(CourseDto course) {
        Course courseEntity = new Course(
            course.id(),
            course.courseName(),
            course.courseCode(),
            course.courseCredit(),
            course.professorId(),
            course.semesterId(),
            course.maxEnrollment(),
            course.currentEnrollment()
        );
        courseRepository.save(courseEntity);
        return "Course added successfully";
    }

    @Override
    public String updateCourse(CourseDto course) {
        Course courseEntity = courseRepository.findById(course.id()).orElse(null);
        if (courseEntity == null) {
            return "Course not found";
        }

        courseEntity.setCourseName(course.courseName());
        courseEntity.setCourseCode(course.courseCode());
        courseEntity.setCourseCredit(course.courseCredit());
        courseEntity.setProfessorId(course.professorId());
        courseEntity.setSemesterId(course.semesterId());
        courseEntity.setMaxEnrollment(course.maxEnrollment());
        courseEntity.setCurrentEnrollment(course.currentEnrollment());

        courseRepository.save(courseEntity);

        return "Course updated successfully";
    }

    @Override
    public String deleteCourse(Long id) {
        if (courseRepository.findById(id) == null) {
            return "Course not found";
        }
        courseRepository.deleteById(id);
        return "Course deleted successfully";
    }

    @Override
    public List<Map<String, String>> getCourseList() {
        List<Course> courseList = courseRepository.findAll();
        List<Map<String, String>> courseListDto = new ArrayList<>();
        for (Course course : courseList) {
            Map<String, String> courseDto = new HashMap<>();
            courseDto.put("CourseId", course.getId().toString());
            courseDto.put("CourseName", course.getCourseName());
            courseDto.put("CourseCode", course.getCourseCode());
            courseDto.put("CourseCredit", String.valueOf(course.getCourseCredit()));
            courseDto.put("ProfessorId", course.getProfessorId().toString());
            courseListDto.add(courseDto);
        }
        return courseListDto;
    }
}
