import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2023_신기한소수 {
    static int[] odd = {1, 3, 5, 7, 9};
    static int[] prime = {2, 3, 5, 7};
    static int N;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < 4; i++) {
            dfs(prime[i], 1);
        }

    }

    static void dfs(int num, int cnt) {
        if (cnt == N) {
            if (isPrime(num))
                System.out.println(num);
            return;
        }
        for (int i = 0; i <odd.length; i ++) {
            if (isPrime(num * 10 + odd[i]))
                dfs(num * 10 + odd[i], cnt + 1);
        }
    }

    static boolean isPrime(int num) {
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
