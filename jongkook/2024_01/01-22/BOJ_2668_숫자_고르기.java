package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class BOJ_2668_숫자_고르기 {
    static int N;
    static int[] above, below;
    static Queue<Integer> queue = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    // 방문 배열을 2개를 써야함
    static boolean[] adoveVisited, belowVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        above = new int[N+1];
        below = new int[N+1];
        for(int n = 1; n <= N; n++){
            above[n] = n;
            below[n] = Integer.parseInt(br.readLine());
        }

        for(int n = 1; n <= N; n++) {
            adoveVisited = new boolean[N+1];
            belowVisited = new boolean[N+1];
            // 재귀를 돌 파라미터, 원본 파라미터, depth
            recursive(above[n], above[n],0);
        }

        sb.append(queue.size()).append("\n");
        while(!queue.isEmpty()) sb.append(queue.poll()).append("\n");

        System.out.println(sb.toString());
    }
    static void recursive(int value, int firstValue, int depth){
        // 윗 배열과 아랫 배열을 돌면서 처음 값을 만나면 queue에 삽입 후 함수 종료
        // 시작하자마자 끝나면 안되기 때문에 depth는 0이 아니여야한다.
        if (value == firstValue && depth != 0){
            queue.add(firstValue);
            return;
        }
        
        // 윗 배열과 아랫 배열을 모두 방문 했는데 원본 값을 만나지 못했다면 함수 종료
        if(adoveVisited[value] && belowVisited[value]) return;
        
        // depth로 윗 배열을 들릴때 아랫 배열을 들릴때를 체크 하면서 방문처리
        if(depth % 2 == 0) adoveVisited[value] = true;
        else belowVisited[value] = true;

        // depth를 기준으로 윗 배열 아랫 배열을 구분하여서 재귀ㄴ
        if(depth % 2 == 0) recursive(below[value], firstValue, depth+1);
        else recursive(above[value], firstValue, depth+1);
    }
}
