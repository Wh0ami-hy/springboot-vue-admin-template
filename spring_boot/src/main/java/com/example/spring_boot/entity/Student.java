package com.example.spring_boot.entity;

public class Student {
    private String name;
    private String phone;
    private Integer id;
    private String classes;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getId() {
        return id;
    }

    public String getClasses() {
        return classes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", id='" + id + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
