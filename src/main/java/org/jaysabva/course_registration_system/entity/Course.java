package org.jaysabva.course_registration_system.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Table(name = "Course")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "course_name")
    public String courseName;

    @Column(name = "course_code")
    public String courseCode;

    @Column(name = "course_credit")
    public int courseCredit;

    @Column(name = "professor_id")
    public Long professorId;

    @Column(name = "semester_id")
    public Long semesterId;

    @Column(name = "max_enrollment")
    public int maxEnrollment;

    @Column(name = "current_enrollment")
    public int currentEnrollment;

    public Course() {

    }

    public Course(Long id, String courseName, String courseCode, int courseCredit, Long professorId, Long semesterId, int maxEnrollment, int currentEnrollment) {
        this.id = id;
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCredit = courseCredit;
        this.professorId = professorId;
        this.semesterId = semesterId;
        this.maxEnrollment = maxEnrollment;
        this.currentEnrollment = currentEnrollment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseCredit() {
        return courseCredit;
    }

    public void setCourseCredit(int courseCredit) {
        this.courseCredit = courseCredit;
    }

    public Long getProfessorId() {
        return professorId;
    }

    public void setProfessorId(Long professorId) {
        this.professorId = professorId;
    }

    public Long getSemesterId() {
        return semesterId;
    }

    public void setSemesterId(Long semesterId) {
        this.semesterId = semesterId;
    }

    public int getMaxEnrollment() {
        return maxEnrollment;
    }

    public void setMaxEnrollment(int maxEnrollment) {
        this.maxEnrollment = maxEnrollment;
    }

    public int getCurrentEnrollment() {
        return currentEnrollment;
    }

    public void setCurrentEnrollment(int currentEnrollment) {
        this.currentEnrollment = currentEnrollment;
    }
}
