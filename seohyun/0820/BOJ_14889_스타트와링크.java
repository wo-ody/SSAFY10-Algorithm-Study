package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_14889_스타트와링크 {
    static int N;
    static int[][] map;
    static boolean[] team;

    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        team = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        comb(0,0);
        System.out.println(result);

    }

    static void comb(int idx, int cnt) {
        if(cnt == N/2){
            ArrayList<Integer> A = new ArrayList<>();
            ArrayList<Integer> B = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if(team[i]) A.add(i);
                else B.add(i);
            }

            int sumA = 0;
            int sumB = 0;
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N/2; j++) {
                    if(i==j) continue;
                    sumA += map[A.get(i)][A.get(j)];
                }
            }
            for (int i = 0; i < N/2; i++) {
                for (int j = 0; j < N/2; j++) {
                    if(i==j) continue;
                    sumB += map[B.get(i)][B.get(j)];
                }
            }

            result = Math.min(result, Math.abs(sumA - sumB));

            return;
        }

        for (int i = idx; i < N; i++) {
            team[i] = true;
            comb(i+1,cnt+1);
            team[i] = false;
        }
    }
}
