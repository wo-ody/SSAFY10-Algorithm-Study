import java.util.Scanner;

public class BOJ_9656_돌게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if(N % 2 == 0)
            System.out.println("SK");
        else
            System.out.println("CY");
    }
}
