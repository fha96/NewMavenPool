package com.group.registration.model.dao;

import com.group.registration.model.entity.Course;
import com.group.registration.model.entity.Schedule;
import com.group.registration.model.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ScheduleDAO {
    ArrayList<Schedule> findByIdSchedule(String idSchedule) throws SQLException;

    ArrayList<Student> findByIdCourse(String idCourse);

    ArrayList<Course> findByIdStudent(String idStudent);

    ArrayList<Student> buildStudentList(ResultSet resultSet, ArrayList<Student> listType);

    ArrayList<Course> buildCourseList(ResultSet resultSet, ArrayList<Course> listType);
}
