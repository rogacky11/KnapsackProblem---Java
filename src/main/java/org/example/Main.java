package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of items: ");
        int n = scanner.nextInt();

        System.out.println("Enter the capacity of the backpack: ");
        int capacity = scanner.nextInt();

        System.out.println("Enter the seed value: ");
        int seed = scanner.nextInt();

        Problem problem = new Problem(n, seed);
        System.out.println(problem.toString());

        Result result = problem.solve(capacity);
        System.out.println(result.toString());
    }
}