import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11536_줄세우기 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = new String[N];
        String[] asc = new String[N];
        String[] desc = new String[N];
        String s = "";
        for(int i = 0; i<N; i++){
            s = br.readLine();
            input[i] = s;
            asc[i] = s;
            desc[i] = s;
        }

        Arrays.sort(asc);
        Arrays.sort(desc, (s1, s2)->s2.compareTo(s1));

        boolean isAsc = true;
        boolean isDesc = true;
        for(int i = 0; i<N; i++){
            if(input[i] != asc[i]){
                isAsc = false;
                break;
            }
        }
        for(int i = 0; i<N; i++){
            if(input[i] != desc[i]){
                isDesc = false;
                break;
            }
        }
        if(isAsc) System.out.println("INCREASING");
        else if(isDesc) System.out.println("DECREASING");
        else System.out.println("NEITHER");
    }
}
