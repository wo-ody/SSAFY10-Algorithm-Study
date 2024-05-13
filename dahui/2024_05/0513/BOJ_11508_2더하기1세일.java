import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_11508_2더하기1세일 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list, (o1, o2) -> o2 - o1);
        int ans = 0;
        int num = list.size() % 3;
        for (int i = 0; i < list.size() - num; i++) {
            if (i % 3 != 2) ans += list.get(i);
        }
        for (int i = list.size() - num; i < list.size(); i++) {
            ans += list.get(i);
        }
        System.out.println(ans);
    }
}
