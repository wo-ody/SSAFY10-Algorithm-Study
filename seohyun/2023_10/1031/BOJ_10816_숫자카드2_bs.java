package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_10816_숫자카드2 {
    static int N,M;
    static int[] card;
    static int[] su;

    static HashMap<Integer,Integer> hmap = new HashMap<>();

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(hmap.containsKey(num)){
                int cnt = hmap.get(num);
                hmap.put(num, cnt + 1);
            }
            else{
                hmap.put(num,1);
            }
        }

        int size = hmap.size();
        card = new int[size];
        int idx = 0;
        for(int su : hmap.keySet()){
            card[idx++] = su;
        }

        M = Integer.parseInt(br.readLine());
        su = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            su[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);
        simulation();
    }
    static boolean BSearch(int num){
        int low = 0;
        int high = card.length - 1;

        while(low <= high){
            int mid = (low + high) / 2;

            if(card[mid] == num) return true;

            if(card[mid] < num) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    static void simulation(){
        int result;
        for(int num : su){
            if(BSearch(num)) result = hmap.get(num);
            else result = 0;
            sb.append(result).append(' ');
        }
        System.out.println(sb);
    }

}
