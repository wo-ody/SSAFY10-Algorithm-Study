import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_1755_숫자놀이 {
    static String[] number = new String[]{"zero", "one", "two", "three"
            , "four", "five", "six", "seven", "eight", "nine"
    };
    static HashMap<String, Integer> map = new HashMap<>();
    static int M,N;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        for (int i = M; i <= N; i++) {
            int ten = i/10;
            int one = i%10;
            String str = "";
            if (ten == 0) {
                str = number[one];
            }else {
                str = number[ten] + " " + number[one];
            }
            map.put(str, i);
        }

        ArrayList<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            sb.append(map.get(list.get(i))).append(" ");
            if ( i%10 == 9) sb.append("\n");
        }
        System.out.println(sb);
    }
}
