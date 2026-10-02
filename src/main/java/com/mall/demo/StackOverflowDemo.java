package com.mall.demo;

public class StackOverflowDemo {

    private static long count = 0;

    public static void main(String[] args) {

        recurse();

    }

    private static void recurse() {

        count++;

        if (count % 1000 == 0) {

            System.out.println(
                    "当前递归次数："
                            + count
            );

        }

        recurse();
    }
}