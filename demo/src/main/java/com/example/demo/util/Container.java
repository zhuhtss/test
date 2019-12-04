package com.example.demo.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 多线程容器
 */
public class Container {
    volatile List<Object> list = new ArrayList<>(10);

    public void add(Object o) {
        list.add(o);
    }

    public int size() {
        return list.size();
    }

    public static void main(String[] args) {
        Container container = new Container();
        Object lock = new Object();

        new Thread(() -> {
            synchronized (lock) {
                for (int i = 0; i < 10; i++) {
                    container.add(new Object());
                    System.out.println("当前线程为：" + Thread.currentThread().getName() + ",i=" + i);
                    if (container.size() == 5) {
                        //lock.notify();
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "t1").start();

        /*try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        new Thread(() -> {
            synchronized (lock) {
                System.out.println("当前线程为：" + Thread.currentThread().getName() + "的线程启动");
                if (container.size() != 5) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("当前线程为：" + Thread.currentThread().getName() + "的线程结束");
                lock.notify();
            }
        }, "t2").start();
    }
}
