import java.io.*;
import java.util.*;

public class Main {

    private static int F, S, G, U, D;
    private static int result;
    private static boolean[] isVisited;

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();

        q.add(S);
        isVisited[S] = true;

        while (!q.isEmpty()) {

            int size = q.size();
            for (int i = 0; i < size; i++) {
                int now = q.poll();

                if (now == G) return;

                int up = now + U;
                int down = now - D;

                if (now < up && up > 0 && up <= F) {
                    if(!isVisited[up]) {
                        isVisited[up] = true;
                        q.add(up);
                    }
                }

                if (now > down && down > 0 && down <= F) {
                    if (!isVisited[down]) {
                        isVisited[down] = true;
                        q.add(down);
                    }
                }
            }
            result++;
        }
        result = Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        F = sc.nextInt();
        S = sc.nextInt();
        G = sc.nextInt();
        U = sc.nextInt();
        D = sc.nextInt();

        result = 0;
        isVisited = new boolean[F + 1];

        bfs();

        if (result == Integer.MAX_VALUE)
            System.out.println("use the stairs");
        else
            System.out.println(result);
    }
}
