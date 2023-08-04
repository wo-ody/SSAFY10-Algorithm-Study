import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static PriorityQueue<Integer> pqueue = new PriorityQueue<>();
	static int N;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception, IOException {
		N = Integer.parseInt(br.readLine()); //수의 개수 입력

		for (int i = 0; i < N; i++) {
			pqueue.add(Integer.parseInt(br.readLine())); //pqueue에 수 입력 

		}
		for (int i = 0; i < N; i++) {
			sb.append(pqueue.poll()).append("\n"); 

		}//pqueue에서 정렬된 채로 출력
		System.out.print(sb);
	}

}
