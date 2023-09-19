

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int k = sc.nextInt();

        boolean[] check = new boolean[k+1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{a,0});
        while (!q.isEmpty()) {
            int[] x = q.poll();
            if (x[0] == k) {
                System.out.println(x[1]);
                return;
            }
            if (x[0] * 2 <= k) {
                check[x[0] * 2] = true;
                q.add(new int[] {x[0] * 2, x[1]+1});
            }

            if (!check[x[0]+1]) {
                q.add(new int[] {x[0] + 1, x[1]+1});
            }
        }
    }

}
