package com.mall.demo;

public class JvmMemoryDemo {

    private static final long MB =
            1024 * 1024;

    public static void main(String[] args) {

        Runtime runtime =
                Runtime.getRuntime();

        long maxMemory =
                runtime.maxMemory() / MB;

        long totalMemory =
                runtime.totalMemory() / MB;

        long freeMemory =
                runtime.freeMemory() / MB;

        long usedMemory =
                totalMemory - freeMemory;

        System.out.println(
                "JVM最大堆内存："
                        + maxMemory
                        + " MB"
        );

        System.out.println(
                "JVM当前已申请堆内存："
                        + totalMemory
                        + " MB"
        );

        System.out.println(
                "当前已使用堆内存约："
                        + usedMemory
                        + " MB"
        );

        System.out.println(
                "当前空闲堆内存约："
                        + freeMemory
                        + " MB"
        );
    }
}