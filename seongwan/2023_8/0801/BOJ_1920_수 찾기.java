import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashSet<Integer> A = new HashSet<>(); //중복 x
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        } // 비교 대상 HashSet A

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int b = Integer.parseInt(st.nextToken());
            if (A.contains(b)) {
                sb.append(1).append(" ").append("\n");//b가 존재하면 1출력
            } else {
                sb.append(0).append(" ").append("\n");//b가 존재하지 않으면 0출력
            }
        }
        System.out.println(sb);
    }
}
