package com.group.registration.model.dao;

import com.group.registration.model.entity.Student;

import java.sql.SQLException;

public interface StudentDAO {
    Student findById(int id) throws SQLException;
    Student findByEmail(String email) throws SQLException;
    void save(Student student) throws SQLException;
    void update(Student student, int id) throws SQLException;
    void delete(int id) throws SQLException;
}
