import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_7795_먹을것인가먹힐것인가 {
    static int T, N, M;
    static int[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            A = new int[N];
            B = new int[M];
            st =new StringTokenizer(br.readLine());
            for(int i = 0; i<N; i++){
                A[i]=Integer.parseInt(st.nextToken());
            }
            st =new StringTokenizer(br.readLine());
            for(int i = 0; i<M; i++){
                B[i] = Integer.parseInt(st.nextToken());
                            }
            Arrays.sort(B);
            int ans = 0;
            for(int i = 0; i<N; i++){
                int start = 0;
                int end = M-1;
                int mid = 0;
                int idx = 0;
                while(start<=end){
                    mid = (start+end)/2;
                    if(A[i] > B[mid]){
                        start = mid+1;
                        idx = mid +1;
                    } else{
                        end = mid -1;
                    }
                }
                ans += idx;
            }

            System.out.println(ans);
        }

    }
}
