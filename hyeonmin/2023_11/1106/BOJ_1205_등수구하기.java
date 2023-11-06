package Algorithm_2023.src.month11.day06;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1205_등수구하기 {

    static int N, score, P, ans;
    static int[] scoreList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 비오름차순의 의미를 알고 있자
        // 랭킹 리스트
        // int의 범위 약 +- 20억
        // 10 <= P <= 50, 0 <= N <= 50
        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        scoreList = new int[P];
        // 태수의 점수 입력
        // P번 안에 score가 나오지 못하면 -1을 출력한다.

        if(N > 0) {
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                scoreList[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = N; i < P; i++) {
                scoreList[i] = -1;
            }

            // 인덱스가 0~P인 배열에 N개의 점수가 비오름차순(내림차순)으로 존재한다.
            // N개 뒤로는 -1로 채워진다.
            // 0부터 P까지 랭크를 본다.
            // 만약에 내 랭크를 알 수 있다면 나랑 같은애들이 몇명인지 찾는다.
            // P-1 이 나보다 작다면? rank 출력
            ans = -1;
            int rank = 0;
            int prevScore = Integer.MAX_VALUE;
            int cnt = 0;
            for (int i = 0; i < P; i++) {
                int curScore = scoreList[i];
                if (curScore < prevScore) rank = i+1;
//                System.out.println("rank : " + rank);
                prevScore = curScore;
                if (curScore <= score) {
                    if(scoreList[P-1] != score) ans = rank;
                    break;
                }
            }
            bw.write(""+ans);
        } else {
            bw.write(""+1);
        }
        bw.flush();
    }
}

