import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_2346_풍선터뜨리기 {
    static Queue<int[]> q = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            q.add(new int[]{Integer.parseInt(st.nextToken()), i+1});
        }
        int[] num = q.poll();
        sb.append(num[1]).append(" ");
        while(!q.isEmpty()) {
            if(num[0] > 0){
                for (int i = 0; i < num[0]-1; i++) {
                    q.add(q.poll());
                }
            }else {
                for (int i = 0; i < q.size()+(num[0]%q.size()); i++) {
                    q.add(q.poll());
                }
            }
            num = q.poll();
            sb.append(num[1]).append(" ");
        }
        System.out.println(sb);

    }
}
