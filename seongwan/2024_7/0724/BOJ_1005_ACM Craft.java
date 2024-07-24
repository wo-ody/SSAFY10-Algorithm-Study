import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static int T, N, K, W;
    static StringBuilder sb = new StringBuilder();
    static int[] time;
    static int[] preCount;
    static List<Integer>[] postList;
    static PriorityQueue<Integer> queue = new PriorityQueue<>((e1, e2) -> time[e1] - time[e2]);

    public static void main(String[] args) throws Exception {
        Reader in = new Reader();

        T = in.nextInt();
        for (int t = 0; t < T; t++) {
            N = in.nextInt();
            K = in.nextInt();
            int ans = 0;

            time = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                time[i] = in.nextInt();
            }

            preCount = new int[N + 1];
            postList = new List[N + 1];

            for (int i = 1; i <= N; i++) {
                postList[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                int pre = in.nextInt();
                int post = in.nextInt();

                preCount[post]++;
                postList[pre].add(post);
            }
            W = in.nextInt();

            for (int i = 1; i <= N; i++) {
                if (preCount[i] == 0) {
                    if (i == W) {
                        ans += time[i];
                        queue.clear();
                        break;
                    }
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                int temp = queue.poll();
                ans += time[temp];

                for (Integer i : queue) {
                    time[i] -= time[temp];
                }

                for (Integer i : postList[temp]) {
                    preCount[i]--;
                    if (preCount[i] == 0) {
                        if (i == W) {
                            ans += time[i];
                            queue.clear();
                            break;
                        }
                        queue.add(i);
                    }
                }
            }

            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static class Reader {
        final int SIZE = 1 << 13;
        byte[] buffer = new byte[SIZE];
        int index, size;

        String nextString() throws Exception {
            StringBuilder sb = new StringBuilder();
            byte c;
            while ((c = read()) < 32) {
                if (size < 0) return "endLine";
            }
            do sb.appendCodePoint(c);
            while ((c = read()) > 32); // SPACE 분리라면 >로, 줄당 분리라면 >=로
            return sb.toString();
        }

        char nextChar() throws Exception {
            byte c;
            while ((c = read()) < 32) ; // SPACE 분리라면 <=로, SPACE 무시라면 <로
            return (char) c;
        }

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

        long nextLong() throws Exception {
            long n = 0;
            byte c;
            boolean isMinus = false;
            while ((c = read()) <= 32) ;
            if (c == 45) {
                c = read();
                isMinus = true;
            }
            do n = (n << 3) + (n << 1) + (c & 15);
            while (isNumber(c = read()));
            return isMinus ? ~n + 1 : n;
        }

        double nextDouble() throws Exception {
            double n = 0, div = 1;
            byte c;
            boolean isMinus = false;
            while ((c = read()) <= 32) {
                if (size < 0) return -12345;
            }
            if (c == 45) {
                c = read();
                isMinus = true;
            } else if (c == 46) {
                c = read();
            }
            do n = (n * 10) + (c & 15);
            while (isNumber(c = read()));
            if (c == 46) {
                while (isNumber(c = read())) {
                    n += (c - 48) / (div *= 10);
                }
            }
            return isMinus ? -n : n;
        }

        boolean isNumber(byte c) {
            return 47 < c && c < 58;
        }

        boolean isAlphabet(byte c) {
            return (64 < c && c < 91) || (96 < c && c < 123);
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