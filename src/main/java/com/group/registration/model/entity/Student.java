package com.group.registration.model.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Student {
    int id;
    String firstName;
    String lastName;
    String email;
    String password;
    String joinYear;

    public Student() {
    }

    //find student by email or id
    public Student(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            this.id=Integer.parseInt(resultSet.getString(1));
            this.firstName=resultSet.getString(2);
            this.lastName=resultSet.getString(3);
            this.email=resultSet.getString(4);
            this.password=resultSet.getString(5);
            this.joinYear=resultSet.getString(6);
        }

    }

    public Student(String firstName, String lastName, String joinYear) {
        this.id=idCounter() ;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = getEmail();
        this.password = getPassword();
        this.joinYear = joinYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJoinYear() {
        return joinYear;
    }

    public void setJoinYear(String joinYear) {
        this.joinYear = joinYear;
    }

    private static int idCounter(){
        int idc=6;
        return idc++ ;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", joinYear='" + joinYear + '\'' +
                '}';
    }
}
