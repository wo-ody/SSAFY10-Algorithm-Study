import java.io.*;
import java.util.*;

public class Main {
    static class Shortcut implements Comparable<Shortcut> {
        int start, end, time;
        
        public Shortcut(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
        
        @Override
        public int compareTo(Shortcut o) {
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 지름길의 개수
        int D = Integer.parseInt(st.nextToken()); // 고속도로의 길이
        ArrayList<Shortcut> shortcuts = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            if (end <= D) { // 목적지를 넘어서는 지름길은 제외
                shortcuts.add(new Shortcut(start, end, time));
            }
        }
        
        Collections.sort(shortcuts); // 끝나는 지점 기준으로 정렬
        
        int[] dp = new int[D + 1];
        for (int i = 1; i <= D; i++) {
            dp[i] = dp[i - 1] + 1; // 지름길을 사용하지 않고 직진하는 경우
            for (Shortcut sc : shortcuts) {
                if (sc.end == i) { // 지름길의 끝 지점에 도달했을 때
                    dp[i] = Math.min(dp[i], dp[sc.start] + sc.time);
                }
            }
        }
        
        System.out.println(dp[D]);
    }
}
