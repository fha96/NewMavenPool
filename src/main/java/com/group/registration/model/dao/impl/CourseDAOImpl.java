package com.group.registration.model.dao.impl;

import com.group.registration.model.dao.CourseDAO;
import com.group.registration.model.entity.Course;
import com.group.registration.model.entity.Student;
import jeaQueue.DataBaseConnectionPool;

import java.sql.SQLException;

public class CourseDAOImpl implements CourseDAO {
    DataBaseConnectionPool connectionPool;

    public CourseDAOImpl() throws SQLException {
        connectionPool=new DataBaseConnectionPool();
        connectionPool.releaseConnection(connectionPool.getConnection());
    }

    public Course findById(String id) throws SQLException {
        String findId="SELECT * course" +
                "where id="+id;
        return new Course(connectionPool.executeQuery(findId));
    }

    public Course findByName(String courseName) throws SQLException {
        String findEmail="Select *from course "+
                "where email='"+courseName+"'";
        connectionPool.executeQuery(findEmail);
        return new Course(connectionPool.executeQuery(findEmail));

    }
    public void create(Course course) throws SQLException {
        String save="insert into studentdb.course(id,name,code,capacity) "+
                "values(?,?,?,?);";
        System.out.println("after string save !");
        connectionPool.executeSaveCourse(save,course);
    }
}
