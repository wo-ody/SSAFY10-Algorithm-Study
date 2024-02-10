import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ_10816_숫자카드2 {
    static int N,M;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, Integer> map = new HashMap<>();
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else map.put(num, 1);
        }
        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            sb.append(map.get(num)==null?0:map.get(num)).append(" ");
        }
        System.out.println(sb);

    }
}
