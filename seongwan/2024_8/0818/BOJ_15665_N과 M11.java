import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int N, M;
    static boolean[] check = new boolean[10001];
    static List<Integer> numbers = new ArrayList<>();
    static int[] tgt;

    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(st.nextToken());
            if (!check[temp]) {
                check[temp] = true;
                numbers.add(temp);
            }
        }

        numbers.sort((e1, e2) -> e1 - e2);

        tgt = new int[M];
        perm(0);
        System.out.println(sb);
    }

    static void perm(int idx) {
        if (idx == M) {
            for (int i : tgt) {
                sb.append(i).append(" ");
            }
            sb.append("\n");

            return;
        }

        for (Integer number : numbers) {
            tgt[idx] = number;
            perm(idx + 1);
        }
    }
}