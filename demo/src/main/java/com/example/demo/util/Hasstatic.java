package com.example.demo.util;

public class Hasstatic {
    private static int x=100;

    public static void main(String[] args) {
        Hasstatic hs1 = new Hasstatic();
        hs1.x++;
        Hasstatic hs2 = new Hasstatic();
        hs2.x++;
        hs1=new Hasstatic();
        hs1.x++;
        Hasstatic.x--;
        System.err.println("x=" +x);
    }
}
