import java.io.*;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static int n, m;
    static boolean[] visited;
    static int[] array;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        array = new int[m];
        NtoM(0);
        System.out.println(sb);
    }

    private static void NtoM(int depth) {
        if (depth == m) {
            for (int val : array) {
                sb.append(val).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            visited[i] = true;
            array[depth] = i + 1;
            NtoM(depth + 1);
            visited[i] = false;
        }
    }
}
