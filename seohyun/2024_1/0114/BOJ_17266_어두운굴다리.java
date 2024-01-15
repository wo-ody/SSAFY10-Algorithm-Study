package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_17266_어두운굴다리 {
    static int N,M;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        arr = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        simulation();
    }

    static int get_size(int front, int end, int cnt){

        while(true){
            if(front+cnt >= end-cnt) break;
            cnt++;
        }

        return cnt;
    }

    static void simulation(){
        if(M==1){
            System.out.println(Math.max(arr[0] - 0, N-arr[0]));
          }
        else{
            int cnt = arr[0] - 0;
            for (int i = 0; i < M - 1; i++) {
                cnt = get_size(arr[i], arr[i+1],cnt);
            }
            cnt = Math.max(cnt, N-arr[M-1]);
            System.out.println(cnt);
        }
    }
}
