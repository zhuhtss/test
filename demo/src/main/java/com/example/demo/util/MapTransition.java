package com.example.demo.util;

import java.util.*;

public class MapTransition {
    public static void main(String[] args) {
        List<Map<String, Object>> list = new ArrayList<>();
        Map<String, Object> m1 = new HashMap<>();
        m1.put("a", 1);
        m1.put("c", 3);
        Map<String, Object> m2 = new HashMap<>();
        m2.put("a", 11);
        m2.put("b", 2);
        Map<String, Object> m3 = new HashMap<>();
        m3.put("a", 111);
        m3.put("c", 1);
        Map<String, Object> m4 = new HashMap<>();
        m4.put("b", 22);
        Map<String, Object> m5 = new HashMap<>();
        m5.put("a", 1111);
        m5.put("b", 222);
        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);
        list.add(m5);
        System.out.println("未分组排序数据:" + list);
        System.out.println("已分组排序数据:" + transition(list));
    }

    public static Map<String, List<Map<String, Object>>> transition(List<Map<String, Object>> list) {
        Map<String, List<Map<String, Object>>> map = new HashMap<>();
        // 分组
        for (Map<String, Object> temp : list) {
            // 获取Map的每一对值
            Iterator<Map.Entry<String, Object>> iterator = temp.entrySet().iterator();
            while (iterator.hasNext()) {
                List<Map<String, Object>> listAndMap = new ArrayList<>();
                // 获取到每一个实体
                Map.Entry<String, Object> entity = iterator.next();
                if (map.containsKey(entity.getKey())) {
                    // 获取原来存在的数据
                    List<Map<String, Object>> lm = map.get(entity.getKey());
                    lm.add(new HashMap<String, Object>() {{
                        put(entity.getKey(), entity.getValue());
                    }});
                    Collections.sort(lm, (param1, param2) -> (param2.get(entity.getKey()).toString().compareTo(param1.get(entity.getKey()).toString()))
                    );
                    map.replace(entity.getKey(), lm);
                } else {
                    listAndMap.add(new HashMap<String, Object>() {{
                        put(entity.getKey(), entity.getValue());
                    }});
                    map.put(entity.getKey(), listAndMap);
                }
            }
        }
        return map;
    }
}
