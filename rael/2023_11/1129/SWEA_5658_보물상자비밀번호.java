import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_보물상자비밀번호 {
    static int T, N, K;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            int oneSize = N/4;      //한 변에 들어가는 숫자 길이

            String s = br.readLine();
            s = s + s.substring(0, oneSize-1);

            //중복 제거를 위한 HashSet
            HashSet<String> hs = new HashSet<>();
            for(int i=0; i<N; i++){
                hs.add(s.substring(i, i+oneSize).toString());
            }
            //정렬을 위한 ArrayList
            ArrayList<String> list = new ArrayList<>(hs);
            Collections.sort(list, Collections.reverseOrder());

            sb.append("#").append(t).append(" ").append(Integer.valueOf(list.get(K-1), 16).toString()).append("\n");
        }
        System.out.println(sb);
    }
}
