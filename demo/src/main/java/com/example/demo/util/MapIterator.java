package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapIterator {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 遍历map
     */
    public static void traverseMap(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        //Lambda表达式，代码简单易懂
        map.forEach((k, v) -> {
            System.out.println(k + "," + v);
        });

    }

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("1", "aaa");
        map.put("2", "bbb");
        map.put("3", "ccc");
        map.put("4", "ddd");


        //Lambda表达式，代码简单易懂
        map.forEach((key, value) -> {
            System.err.println("key:" + key + "---------value:" + value);
        });
        MapIterator mapt = new MapIterator();
        mapt.setName("aaaaaa");
        Function<MapIterator, String> function = MapIterator::getName;
        String namee = function.apply(mapt);
        System.err.println(namee);
    }
}
