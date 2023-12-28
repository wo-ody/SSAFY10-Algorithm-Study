import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] splited = sc.nextLine().split(":");
        int N = stoi(splited[0]);
        int M = stoi(splited[1]);
        int GCD = gcd(Math.max(N, M), Math.min(N, M));

        System.out.println(N / GCD + ":" + M / GCD);
    }
    //유클리드 호제법
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static int stoi(String s) { return Integer.parseInt(s); }
}
