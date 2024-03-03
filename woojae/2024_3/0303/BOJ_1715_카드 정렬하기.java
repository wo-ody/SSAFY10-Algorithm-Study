import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++)
            pq.add(Integer.parseInt(br.readLine()));

        ArrayList<Integer> pair = new ArrayList<>();  // 두 카드 묶음을 저장할 리스트
        int new_deck = 0;  // 합친 카드 묶음의 수

        while (!pq.isEmpty()) {  // 처리해야 할 카드 묶음이 있을 때까지
            pair.add(pq.poll());  // 카드 묶음을 빼서 저장

            if(pair.size() == 2) {  // 두 카드 묶음이 완성 되었다면
                answer += pair.stream().mapToInt(Integer::intValue).sum();  // 하나로 합침
                for(int i=0; i < 2; i++)
                    new_deck += pair.remove(pair.size()-1);  // 다음 카드 묶음을 만들기 위해 리스트에서 제거 해서 새로운 묶음에 저장
                pq.add(new_deck);  // 하나로 합쳐진 카드 묶음은 다시 큐에 저장
                new_deck = 0;  // 다음 묶음을 위해 값 초기화
            }
        }
        System.out.println(answer);
    }
}
