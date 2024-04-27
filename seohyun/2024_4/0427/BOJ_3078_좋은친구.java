import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static ArrayList<Integer>[] map = new ArrayList[30];

    static long result = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 20; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            map[input.length()].add(i + 1); // 등수 넣어주기
        }

        simulation();

    }

    static void get_result(ArrayList<Integer> arr){
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < arr.size(); i++) {
            int cur = arr.get(i);

            while(!dq.isEmpty() && cur - dq.peekFirst() > K){
                dq.pollFirst();
            }

            result += dq.size();

            dq.addLast(cur);
        }
    }

    static void simulation(){
        for (int i = 0; i <= 20; i++) {
            if(map[i].size() == 0) continue;
            get_result(map[i]);
        }

        System.out.println(result);
    }

}
