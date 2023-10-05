import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182_부분수열의합 {
    static int N, S, ans;
    static int[] src;
    static boolean[] select;

    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        src = new int[N];
        select= new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<N; i++){
            src[i] = Integer.parseInt(st.nextToken());
        }

        subset(0);
        System.out.println(ans);
    }

    static void subset(int srcIdx){
        if(srcIdx == N){
            // complete code;
            int sum = 0;
            int cnt = 0;
            for(int i = 0; i<N; i++){
                if(select[i]){
                    cnt+=1;
                    sum+=src[i];
                }
            }
            if(sum == S && cnt !=0){
                ans++;
            }
            return;
        }
        select[srcIdx] = true;
        subset(srcIdx+1);
        select[srcIdx] = false;
        subset(srcIdx+1);
    }
}
