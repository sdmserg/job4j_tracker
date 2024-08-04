package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Alexandrov Pavel Ivanovich");
        student.setGroup("MTS-21");
        student.setAddmissionDate(new Date());
        System.out.println(student.getFullName() + " from group " + student.getGroup() + " was addmission " + student.getAddmissionDate());
    }
}
