package com.mall.demo;

import java.util.ArrayList;
import java.util.List;

public class HeapOomDemo {

    public static void main(String[] args) {

        List<byte[]> memory =
                new ArrayList<>();

        int count = 0;

        while (true) {

            memory.add(
                    new byte[1024 * 1024]
            );

            count++;

            System.out.println(
                    "已申请约："
                            + count
                            + " MB"
            );
        }
    }
}