import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//Node 클래스에 앞에 와야할 문제 번호는 개수를 세고 뒤에 와야할 문제는 번호 자체를 리스트에 저장함
//pq에 담은 후 앞에 와야할 문제의 개수를 기준으로 같다면 문제 번호를 기준으로 오름차순으로 뽑음
//pq에서 뽑은 node를 이용해 뒤의 문제리스트를 돌며 앞에 와야할 문제 개수를 줄임으로써
//계속해서 나올 수 있는 가장 작은 문제 번호들을 출력하는 방식
public class Main {
	static class Node {
		int num;
		int preCount = 0;
		List<Integer> post = new ArrayList<>();
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Node[] problems;
	static PriorityQueue<Integer> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		problems = new Node[N + 1];

		for (int i = 1; i <= N; i++) {
			problems[i] = new Node();
			problems[i].num = i;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			//뒤에 와야할 문제 번호를 담음
			problems[first].post.add(second);
			//앞에 와야할 문제 개수를 늘림
			problems[second].preCount++;
		}

		//각 문제 번호별 Node를 pq에 담음
		for (int i = 1; i <= N; i++) {
			if (problems[i].preCount == 0)
				pq.add(i);
		}

		while (!pq.isEmpty()) {
			int temp = pq.poll();

			//문제 하나가 해결됨에 따라 해당 문제가 풀려야 풀 수 있는 뒤의 문제들의
			//앞에 풀어야할 문제 수를 줄임
			for (Integer i : problems[temp].post) {
				problems[i].preCount--;
				if (problems[i].preCount == 0) {
					pq.add(i);
				}
			}

			sb.append(temp + " ");
		}

		System.out.println(sb);
	}
}