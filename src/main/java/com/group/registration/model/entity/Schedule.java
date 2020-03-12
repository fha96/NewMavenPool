package com.group.registration.model.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Schedule {
    private int idSchedule;
    private String idCourse;
    private String idStudent;

    public Schedule(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            this.idSchedule=Integer.parseInt(resultSet.getString(1));
            this.idCourse=resultSet.getString(2);
            this.idStudent=resultSet.getString(3);
        }
    }

    public int getIdSchedule() {
        return idSchedule;
    }

    public void setIdSchedule(int idSchedule) {
        this.idSchedule = idSchedule;
    }

    public String getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(String idCourse) {
        this.idCourse = idCourse;
    }

    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    @Override
    public String toString() {
        return "Schedule{" +
                "idSchedule='" + idSchedule + '\'' +
                ", idCourse='" + idCourse + '\'' +
                ", idStudent='" + idStudent + '\'' +
                '}';
    }
}
