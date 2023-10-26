import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] num = new int[20000001];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            int n = Integer.parseInt(st.nextToken());
            num[n+10000000] = 1;
        }

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i =0; i<M; i++){
            int target = Integer.parseInt(st.nextToken());

            if(num[target+10000000] == 1){
                sb.append(1).append(" ");
            } else{
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
    }
}
