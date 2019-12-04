package com.example.demo;

public class TestMain {

    public static void main(String[] args) {
        String str = "BEA";
        modify(str);
        System.err.println(str);

    }

    public static void modify(String strs) {
        strs.replace("A", "E");
        strs.toLowerCase();
        strs += "B";
    }

}
