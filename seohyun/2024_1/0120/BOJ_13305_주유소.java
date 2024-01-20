import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dis;
    static int[] fuel;

    static long result = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        dis = new int[N-1];
        fuel = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N-1; i++) {
            dis[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fuel[i] = Integer.parseInt(st.nextToken());
        }

        //
        simulation();
        System.out.println(result);
    }

    // N = 2 고려
    static void simulation(){

        int gas = fuel[0];

        for (int i = 0; i < N-1; i++) {
            if(fuel[i] < gas){
                gas = fuel[i];
            }
            result += (long)gas * dis[i];
        }

    }

}
