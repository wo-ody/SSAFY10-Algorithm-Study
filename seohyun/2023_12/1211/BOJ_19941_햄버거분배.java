import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,K;
    static char[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = br.readLine().toCharArray();

        int result = 0;
        for (int i = 0; i < N; i++) {
            if (map[i] == 'H' || map[i] == '.') continue;

            for(int j=i-K; j <= i+K; j++){
                if(j < 0 || j >= N ||j==i) continue;
                if(map[j] == 'H'){
                    map[j] = '.';
                    result++;
                    break;
                }
            }
            //System.out.println(i);
            //System.out.println(map);

        }

        System.out.println(result);

    }
}
