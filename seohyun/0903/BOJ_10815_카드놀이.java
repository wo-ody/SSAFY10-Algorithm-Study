import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] card;
    static int[] test;

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        card = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            card[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        test = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            test[i] = Integer.parseInt(st.nextToken());
        }

        // 이분탐색은 정렬 필수
        Arrays.sort(card);
        for(int value : test){
            sb.append(fun(value)).append(" ");
        }
        System.out.println(sb);
    }

    static int fun(int value){
        int low = 0;
        int high = N-1;

        while(low <= high){
            int mid = (low + high) / 2;
            if(card[mid] == value) return 1;
            else if(card[mid] < value) low = mid + 1;
            else high = mid - 1;
        }

        return 0;
    }

}
