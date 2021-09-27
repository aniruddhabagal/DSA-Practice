package com.Sorting;

import java.util.Scanner;

public class linearSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr = new int[10];

        System.out.println("Enter arr ele");
        for (int i = 0; i < 5; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println("Enter Key to search");
         int key;
        key = in.nextInt();

        int pos = search(key, arr);

        System.out.println("Key found in pos " + pos);
    }

    static int search(int key, int[] arr) {

        if (arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < 5; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;

//        Returns -1 if search is unsuccessful
    }

}