import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static boolean prime[] = new boolean[8000002];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Long> list = new ArrayList<Long>();

        prime();

        for (long i = 2; i < 8000000; i++) {
            if (!prime[(int) i]) {
                list.add(i);
            }
        }

        System.out.println(list.get(n - 1));
    }

    static void prime() {
        prime[0] = prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i]) {
                continue;
            }

            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}