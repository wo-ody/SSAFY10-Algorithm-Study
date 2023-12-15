package boj;

import java.io.*;
import java.util.*;
public class boj_2632_피자판매 {
    static int N,A,B;
    static int[] Ai;
    static int[] Bi;
    // < 피자 조각(누적합) : 경우의 수 >
    static HashMap<Integer, Integer> Ap = new HashMap<>();
    static HashMap<Integer, Integer> Bp = new HashMap<>();

    static int result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        Ai = new int[A];
        Bi = new int[B];

        for (int i = 0; i < A; i++) {
            Ai[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < B; i++) {
            Bi[i] = Integer.parseInt(br.readLine());
        }

        // 시작
        make_sum(Ap, Ai);
        make_sum(Bp, Bi);

        simulation();

        System.out.println(result);

    }
    static void make_sum(HashMap<Integer,Integer> hmap, int[] arr){
        int size = arr.length;

        for (int k = 1; k <= size ; k++) {
            int sum = 0;
            for (int i = 0; i < k; i++) sum += arr[i];

            int idx = k;
            while(true){
                // hmap 에 넣고, 하나빼고 idx 에 있는 arr 넣기
                if(!hmap.containsKey(sum)) hmap.put(sum,1);
                else hmap.put(sum, hmap.get(sum) + 1);

                if(idx == k - 1 || k == size) break;

                sum += (arr[idx] - arr[(idx - k) < 0 ? (idx-k) + size : idx - k ]);

                // idx++ 해주기 (순환) , 종료조건 : idx == k - 1
                idx = (idx + 1) % size;
            }
        }

    }

    static void simulation(){
        // 0도 넣어줘야 한다
        Ap.put(0,1);
        Bp.put(0,1);
        for(Integer a : Ap.keySet()){

            int cnt = Ap.get(a);

            if(Bp.containsKey(N - a)) result += (cnt * Bp.get(N-a));
        }
    }
}
