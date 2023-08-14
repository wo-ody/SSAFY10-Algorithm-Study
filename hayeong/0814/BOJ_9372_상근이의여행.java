import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 상근이의여행_9372 {
    static int T, N, M;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t = 0; t<T;t++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            for(int i = 0; i<M; i++){
                st = new StringTokenizer(br.readLine());
            }
            System.out.println(N-1);
        }

    }
}
