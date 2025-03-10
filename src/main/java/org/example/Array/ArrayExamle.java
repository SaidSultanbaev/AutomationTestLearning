package org.example.Array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExamle {
    public static void main(String[] args) {
        System.out.println("Hello Gradle");
    }

    private static void nmadir() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] Arr = new int[n];

        int b = 0;

        newIter:
        for (int i = 0; i < Arr.length; i++) {
            if (b == 0) {
                Arr[i] = sc.nextInt();
            }

            if (b != 0) {
                System.out.println("i = " + i);
                Arr[i] *= b;
                System.out.println("* " + Arr[i]);
            }

            if (i == Arr.length - 1 && b == 0) {
                System.out.println("i po = " + i);
                b = sc.nextInt();
                i = -1;
                continue newIter;
            }
        }
    }

    public static void w() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < (n % 2 == 0 ? n : n - 1); i += 2) {
            if (i == n - 1) continue;

            int temp = arr[i];
            arr[i] = arr[i + 1];
            arr[i + 1] = temp;
        }


        for (int j : arr) {
            System.out.println(j);
        }

    }

    public static void e() {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < arr.length; i++) {
            boolean contains = true;
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] == arr[j] && i != j) {
                    contains = false;
                    break;
                }
            }
            if (contains) System.out.println(arr[i]);
        }


    }

    public static void a() {
        int[] arr = {1, 3, 4, 4, 5, 8};
        int index = Arrays.binarySearch(arr, 4);
        System.out.println(index);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] Arr = new int[n];
        int sum = 0;

        for (int i = 0; i < Arr.length; i++) {
            Arr[i] = sc.nextInt();
            sum += Arr[i];
        }

        System.out.println(sum);

        for (int i = Arr.length - 1; i >= 0; i--) {
            System.out.println(Arr[i]);
        }
    }

    public static void b() {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        int rost = sc.nextInt();
        int index = 1;

        for (int j : arr) {
            if (j >= rost) index++;
        }
        System.out.println(index);
    }
}
