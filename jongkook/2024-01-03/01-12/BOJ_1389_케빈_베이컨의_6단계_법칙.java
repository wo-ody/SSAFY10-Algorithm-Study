package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1389_케빈_베이컨의_6단계_법칙 {
    static int vertex, edge, count[];
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        vertex = Integer.parseInt(st.nextToken());
        edge = Integer.parseInt(st.nextToken());
        graph = new ArrayList[vertex + 1];
        for (int i = 0; i <= vertex; i++) graph[i] = new ArrayList<>();

        count = new int[vertex+1];
        for (int e = 0; e < edge; e++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

//        for(ArrayList<Integer> g : graph) System.out.println(g);
        int MIN = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 1; i <= vertex; i++) {
            int currentNumber = bfs(i);
            if (currentNumber < MIN) {
                MIN = currentNumber;
                result = i;
            }
        }
        System.out.println(result);

//        System.out.println(bfs(5));
    }

    static int bfs(int start) {
        Arrays.fill(count, -1);
        int number = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        count[start] = 0;
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int v : graph[x]) {
                if (count[v] != -1) continue;
                count[v] = count[x] + 1;
                queue.offer(v);
                number += count[v];
            }
        }
        return number;
    }
}
