import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1094_막대기 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String beat = Integer.toBinaryString(N);
        int cnt = 0;
        for (int i = 0; i < beat.length(); i++) {
            char c = beat.charAt(i);
            if (c == '1') cnt++;
        }
        System.out.println(cnt);
    }
}

