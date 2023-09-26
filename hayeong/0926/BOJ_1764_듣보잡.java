import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764_듣보잡 {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map =new HashMap<>();
        ArrayList<String> result = new ArrayList<>();

        for(int i = 0; i<N; i++){
            map.put(br.readLine(), 1);
        }
        for(int i = 0; i<M; i++){
            String tmp = br.readLine();

            if(map.get(tmp) != null){
                result.add(tmp);
            }
        }

        Collections.sort(result);

        StringBuilder sb= new StringBuilder();

        sb.append(result.size()).append("\n");
        for(int i = 0; i< result.size(); i++){
            sb.append(result.get(i)).append("\n");
        }

        System.out.println(sb.toString());

    }
}
