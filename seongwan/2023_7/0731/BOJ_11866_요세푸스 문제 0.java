import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= N; i++) {
            deque.add(i);
        } // 1~N까지 큐에 입력

        while (!deque.isEmpty()) {
            for (int i = 0; i < K - 1; i++) {
                deque.add(deque.poll());
            }
            list.add(deque.poll());
        }
           //큐의 앞에 있는 수를 뒤로 보내면서 K번째 수를 꺼냄
       
        System.out.print("<");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(">");  //리스트 출력을 []에서 <>로 바꿈
    }
}
