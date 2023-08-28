import java.util.Scanner;

public class BOJ_1436_영화감독숌 {
    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        int num = 666;
        int cnt = 1;
        while(cnt != N){
            num++;
            if(String.valueOf(num).contains("666")) cnt++;
        }
        System.out.println(num);
    }
}
