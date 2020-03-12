package com.group.registration.model.dao;

import com.group.registration.model.entity.Course;

import java.sql.SQLException;

public interface CourseDAO {
    Course findById(String id) throws SQLException;
    Course findByName(String courseName) throws SQLException;
    void create(Course course) throws SQLException;




}
