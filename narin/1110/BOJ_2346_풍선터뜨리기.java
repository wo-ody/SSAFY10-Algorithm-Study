import java.util.*;
import java.io.*;

public class Main_2346_풍선터뜨리기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Deque<Balloon> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            q.add(new Balloon(i + 1, sc.nextInt()));
        }

        // System.out.println(q.toString());

        while (!q.isEmpty()) {

            Balloon b = q.poll();
            System.out.print(b.idx + " ");

            int size;
            if (b.num > 0) {
                size = b.num - 1;
            } else {
                size = Math.abs(b.num);
            }

            for (int i = 0; i < size; i++) {
                if (b.num > 0) {
                    if (!q.isEmpty())
                        q.addLast(q.pollFirst());
                } else {
                    if (!q.isEmpty())
                        q.addFirst(q.pollLast());
                }
            }
        }
    }

    static class Balloon {
        int idx, num;

        public Balloon(int idx, int num) {
            this.idx = idx;
            this.num = num;
        }

        @Override
        public String toString() {
            return "[" + idx + ", " + num + "]";
        }
    }
}
