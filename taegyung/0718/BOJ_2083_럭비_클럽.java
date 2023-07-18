// package SSAFY10-Algorithm-Study.taegyung.0718;

import java.util.Scanner;

public class BOJ_2083_럭비_클럽 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String name;
        int age,weight;

        name = sc.next();
        age = sc.nextInt();
        weight = sc.nextInt();

        while(!name.equals("#") || age != 0 || weight != 0){
            System.out.print(name);
            if (age > 17 || weight >= 80){
                System.out.println(" Senior");
            }
            else
                System.out.println(" Junior");
            name = sc.next();
            age = sc.nextInt();
            weight = sc.nextInt();
        }

    }
}
