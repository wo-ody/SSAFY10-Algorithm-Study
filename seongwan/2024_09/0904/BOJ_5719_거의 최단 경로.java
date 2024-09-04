import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static List<int[]>[] adlist;
    static int N, M, start, end;
    static List<Integer>[] preList;
    static boolean[] removeCheck;

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();
        while (true) {
            N = in.nextInt();
            M = in.nextInt();

            if (N == 0)
                break;

            start = in.nextInt();
            end = in.nextInt();

            adlist = new List[N];
            for (int i = 0; i < N; i++) {
                adlist[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                int from = in.nextInt();
                int to = in.nextInt();
                int w = in.nextInt();

                adlist[from].add(new int[]{to, w});
            }
            removeCheck = new boolean[N];
            dijk();
            sb.append(finalDijk()).append("\n");
        }
        System.out.println(sb);
    }

    static void dijk() {
        //node ,pre, w
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[2] - e2[2]);
        int[] check = new int[N];
        Arrays.fill(check, Integer.MAX_VALUE);
        preList = new List[N];
        for (int i = 0; i < N; i++) {
            preList[i] = new ArrayList<>();
        }
        pq.add(new int[]{start, -1, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int pre = cur[1];
            int w = cur[2];

            if (node == end) {
                if (check[node] == Integer.MAX_VALUE)
                    check[node] = w;

                if (check[node] < w)
                    break;

                preList[node].add(pre);
                continue;
            }

            if (check[node] < w)
                continue;

            preList[node].add(pre);

            if (check[node] == w) {
                continue;
            }
            check[node] = w;
            for (int[] next : adlist[node]) {
                int nextNode = next[0];
                int nextW = w + next[1];
                if (check[nextNode] < nextW)
                    continue;
                pq.add(new int[]{nextNode, node, nextW});
            }
        }
        remove(end);
    }

    static void remove(int node) {
        if (node == start || removeCheck[node])
            return;

        removeCheck[node] = true;

        for (Integer pre : preList[node]) {
            for (int i = 0; i < adlist[pre].size(); i++) {
                if (adlist[pre].get(i)[0] == node) {
                    adlist[pre].remove(i);
                    break;
                }
            }
            remove(pre);
        }
    }

    static int finalDijk() {
        //node ,w
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[1] - e2[1]);
        boolean[] visit = new boolean[N];
        pq.add(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0];
            int w = cur[1];

            if (node == end) {
                return w;
            }

            if (visit[node])
                continue;

            visit[node] = true;
            for (int[] next : adlist[node]) {
                int nextNode = next[0];
                int nextW = w + next[1];
                if (visit[nextNode])
                    continue;
                pq.add(new int[]{nextNode, nextW});
            }
        }
        return -1;
    }

    static class Reader {
        final int SIZE = 1 << 13;
        byte[] buffer = new byte[SIZE];
        int index, size;

        int nextInt() throws Exception {
            int n = 0;
            byte c;
            boolean isMinus = false;
            while ((c = read()) <= 32) {
                if (size < 0) return -1;
            }
            if (c == 45) {
                c = read();
                isMinus = true;
            }
            do n = (n << 3) + (n << 1) + (c & 15);
            while (isNumber(c = read()));
            return isMinus ? ~n + 1 : n;
        }

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        byte read() throws Exception {
            if (index == size) {
                size = System.in.read(buffer, index = 0, SIZE);
                if (size < 0) buffer[0] = -1;
            }
            return buffer[index++];
        }
    }
}
