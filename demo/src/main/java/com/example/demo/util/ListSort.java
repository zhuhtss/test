package com.example.demo.util;

import com.example.demo.pojo.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student("111", "aaa", 10));
        list.add(new Student("333", "ccc", 12));
        list.add(new Student("222", "bbb", 11));
        list.add(new Student("555", "eee", 14));
        list.add(new Student("444", "ddd", 13));
        list.add(new Student("000", "000", 9));

        for (Student student : list) {
            System.err.println(student);
        }

        list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });
        for (Student student : list) {
            System.out.println(student);
        }

        Collections.sort(list, (s1, s2) -> (s1.getAge() - s2.getAge()));
        for (Student student : list) {
            System.err.println(student);
        }
    }

}
