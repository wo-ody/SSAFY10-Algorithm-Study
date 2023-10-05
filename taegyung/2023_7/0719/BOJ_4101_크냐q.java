import java.util.Scanner;
public class BOJ_4101_크냐q {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        while (n1 != 0 || n2 != 0){
            if(n1 > n2)
            System.out.println("Yes");
            else
            System.out.println("No");
            n1 = sc.nextInt();
            n2 = sc.nextInt();
        }
    }
}
