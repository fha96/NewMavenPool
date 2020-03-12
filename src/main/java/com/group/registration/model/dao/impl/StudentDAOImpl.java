package com.group.registration.model.dao.impl;

import com.group.registration.model.dao.StudentDAO;
import com.group.registration.model.entity.Student;
import jeaQueue.DataBaseConnectionPool;

import java.sql.SQLException;

public class StudentDAOImpl implements StudentDAO {
    DataBaseConnectionPool connectionPool;

    public StudentDAOImpl() throws SQLException {
        connectionPool=new DataBaseConnectionPool();
        connectionPool.releaseConnection(connectionPool.getConnection());
    }

    public void delete(int id) throws SQLException {
        //  String delete="delete from registration.student"+
        //        "where id=?"+id;
        //      db.executeDelete(delete);

    }

    public Student findById(int id) throws SQLException {
        String findId="SELECT * FROM student " +
                "where id="+id;
        return new Student(connectionPool.executeQuery(findId));
    }
    public Student findByEmail(String email) throws SQLException {
        String findEmail="Select *from student "+
                "where email='"+email+"'";
        connectionPool.executeQuery(findEmail);
        return new Student(connectionPool.executeQuery(findEmail));
    }

    public void save(Student student) throws SQLException {
        String save="insert into registration.student(id,firstName,lastName,email,password,joinYear) "+
                "values(?,?,?,?,?,?);";
        System.out.println("after string save !");
        connectionPool.executeSave(save,student);
    }

    public void update(Student student, int id) throws SQLException {
        String update=" update  registration.student " +" set email=? ,password=?"+
                "where id="+id;
        connectionPool.executeUp(update,student);
    }

}