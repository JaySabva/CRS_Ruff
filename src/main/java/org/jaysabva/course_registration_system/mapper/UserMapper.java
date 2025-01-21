package org.jaysabva.course_registration_system.mapper;

import org.jaysabva.course_registration_system.entity.Semester;
import org.jaysabva.course_registration_system.entity.User;
import org.jaysabva.course_registration_system.dto.UserDto;
import org.jaysabva.course_registration_system.dto.SemesterDto;

public class UserMapper {
    public static UserDto toDto(User user) {
        return new UserDto(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

//    public static User fromDto(UserDto user) {
//        return new User(user.id(), user.name(), user.password());
//    }

    public static SemesterDto toDto(Semester semester) {
        return new SemesterDto(semester.getId(), semester.getName(), semester.getStartDate().toString(), semester.getEndDate().toString());
    }
}
