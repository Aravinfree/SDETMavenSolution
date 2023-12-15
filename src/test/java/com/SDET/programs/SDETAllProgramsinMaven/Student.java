package com.SDET.programs.SDETAllProgramsinMaven;

public class Student {
    private String name;
    private String courses;
    private String fee;

    public Student(String name, String courses, String fee) {
        this.name = name;
        this.courses = courses;
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", courses='" + courses + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}
