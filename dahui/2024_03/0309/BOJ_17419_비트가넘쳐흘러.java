import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_17419_비트가넘쳐흘러 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if (c == '1') cnt++;
        }
        System.out.println(cnt);
    }
}
