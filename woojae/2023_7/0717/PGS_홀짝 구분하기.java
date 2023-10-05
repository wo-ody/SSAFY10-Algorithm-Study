import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean state = n % 2 == 0 ? true : false;
        String answer = state ? " is even" : " is odd";
        System.out.println(n + answer);
    }
}
