package structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1021_회전하는_큐 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int count = 0;
    static Deque<Integer> dq = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] temp = new int[M];
        for(int i = 0 ; i < M ; i++)
            temp[i] = Integer.parseInt(st.nextToken());

        // 필요한 변수
        // 일단 뽑아낼 원소의 위치가 left가 빠른지 right가 빠른지 판별하는 것
        // 아마도 q.size 절반보다 작으면 left 아니면 right가 빠르다.
        // 그걸로 보내주면 끝
        for(int i = 1 ; i <= N ; i++) dq.add(i);

        for(int i = 0 ; i < M ; i++) {

            if(check(temp[i])) {
                while(temp[i]!=dq.peekFirst()) {
                    dq.addLast(dq.pollFirst());
                    count++;
                }
            }else {
                while(temp[i]!=dq.peekFirst()) {
                    dq.addFirst(dq.pollLast());
                    count++;
                }
            }

            dq.poll();
        }


        System.out.println(count);

    }
    public static boolean check(int a) {
        int half = dq.size()/2;
        int count  = 0;

        for(Integer integer: dq){
            if(count > half) return false;
            if (a == integer) return true;
            count++;
        }

        return false;
    }

}