package com.group.registration.model.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Course {
    private int id;
    private String name;
    private String code;
    private Integer capacity;

    public Course(ResultSet resultSet) throws SQLException {
        while (resultSet.next()){
            this.id=Integer.parseInt(resultSet.getString(1));
            this.name=resultSet.getString(2);
            this.code=resultSet.getString(3);
            this.capacity=Integer.parseInt(resultSet.getString(4));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
