import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m;;
	static int[] a;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	
	public static void main(String[] args) throws IOException{
		n = Integer.parseInt(br.readLine());
		a = new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			int v = Integer.parseInt(st.nextToken());
			a[i] = v;
			pq.add(new Node(a[i], i));  // 크기가 가장 작은 값이 항상 정렬되어 있어야 함, 또한 인덱스 정보를 포함해야 함
		}
		
		m = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < m; tc++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			if(q == 1) {
				int i = Integer.parseInt(st.nextToken())-1;
				int v = Integer.parseInt(st.nextToken());
				a[i] = v;
				pq.add(new Node(a[i], i));
			}
			else {
				while(!pq.isEmpty() && a[pq.peek().index] != pq.peek().value)  // 큐의 가장 상단 값이 배열과 일치하지 않다는 것은 변경된 값이 최상단이 아니라는 뜻
					pq.poll();  // 최상단 값이 최소가 되는 노드를 탐색할 때까지 값 제거
				sb.append(pq.peek().index+1).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static class Node implements Comparable<Node>{
		int value, index;
		

		public Node(int value, int index) {
			super();
			this.value = value;
			this.index = index;
		}
		
		@Override
		public int compareTo(Node o) {
			if (this.value == o.value)  // value가 같다면
                return Integer.compare(this.index, o.index);  // 인덱스가 가장 작은 값이 우선
            return Integer.compare(this.value, o.value);  // 아니라면 기본적으로 value가 가장 작은 순으로
		}
	}
}
