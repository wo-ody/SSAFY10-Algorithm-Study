import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N, M, result;
    private static boolean[] broken;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        broken = new boolean[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int temp = Integer.parseInt(st.nextToken());
            broken[temp] = true;
        }

        result  = Math.abs(N-100);

        for(int i =0 ; i<1000000; i++){
            String num = String.valueOf(i);

            boolean isBreak = false;
            for(int j =0; j<num.length(); j++){
                if(broken[num.charAt(j)-'0']){
                    isBreak = true;
                    break;
                }
            }

            if(!isBreak){
                int min = Math.abs(N - i)+num.length();
                result = Math.min(min, result);
            }
        }

        System.out.println(result);
    }
}
