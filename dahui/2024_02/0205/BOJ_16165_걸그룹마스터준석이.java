import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_16165_걸그룹마스터준석이 {
    static int N, M, size, quiz;
    static String team, name, quizStr;
    static StringBuilder sb = new StringBuilder();
    static HashMap<String, String[]> set1 = new HashMap<>();

    //멤버 : 팀이름
    static HashMap<String, String> set2 = new HashMap<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            team = br.readLine();
            size = Integer.parseInt(br.readLine());
            set1.put(team, new String[size]);
            for (int j = 0; j < size; j++) {
                name = br.readLine();
                set1.get(team)[j] = name;
                set2.put(name, team);
            }
        }

        for (int i = 0; i < M; i++) {
            quizStr = br.readLine();
            quiz = Integer.parseInt(br.readLine());
            if(quiz == 0){
                String[] arr = set1.get(quizStr);
                Arrays.sort(arr);
                for (int j = 0; j < arr.length; j++) {
                    sb.append(arr[j]).append("\n");
                }
            }else {
                sb.append(set2.get(quizStr)).append("\n");
            }
        }

        System.out.println(sb);
    }
}
