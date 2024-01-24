package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_13975_파일_합치기 {
    static int T, K;
    static PriorityQueue<Long> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            K = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for (int k = 0; k < K; k++) pq.add(Long.parseLong(st.nextToken()));
            merge();
        }
    }

    static void merge() {
        long result = 0;
        while (pq.size() != 1) {
            long temp = pq.poll() + pq.poll();
            result += temp;
            if (pq.isEmpty()) break;
            pq.add(temp);
        }
        System.out.println(result);
    }
}
