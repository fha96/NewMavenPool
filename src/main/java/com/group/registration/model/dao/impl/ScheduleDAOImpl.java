package com.group.registration.model.dao.impl;

import com.group.registration.model.dao.CourseDAO;
import com.group.registration.model.dao.ScheduleDAO;
import com.group.registration.model.dao.StudentDAO;
import com.group.registration.model.entity.Course;
import com.group.registration.model.entity.Schedule;
import com.group.registration.model.entity.Student;
import jeaQueue.DataBaseConnectionPool;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ScheduleDAOImpl implements ScheduleDAO {
    DataBaseConnectionPool connectionPool;

    private StudentDAO studentDAO;
    private CourseDAO courseDAO;

    public ScheduleDAOImpl(StudentDAO studentDAO, CourseDAO courseDAO) throws SQLException {
        connectionPool=new DataBaseConnectionPool();
        connectionPool.releaseConnection(connectionPool.getConnection());
        this.studentDAO = studentDAO;
        this.courseDAO = courseDAO;
    }

    public ArrayList<Schedule> findByIdSchedule(String idSchedule) throws SQLException {
        String findId="SELECT * FROM schedule " +
                "where id="+idSchedule;
        return new ArrayList<Schedule>((Collection<? extends Schedule>) connectionPool.executeQuery(findId));
    }

    public ArrayList<Student> findByIdCourse(String idCourse) {
        return null;
    }

    public ArrayList<Course> findByIdStudent(String idStudent) {
        return null;
    }

    public ArrayList<Student> buildStudentList(ResultSet resultSet, ArrayList<Student> listType) {
        return null;
    }

    public ArrayList<Course> buildCourseList(ResultSet resultSet, ArrayList<Course> listType) {
        return null;
    }
}
