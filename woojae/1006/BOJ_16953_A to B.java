import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int a, b;
	static int answer = -1;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		solve();
		System.out.println(answer);
	}
	
	static void solve() {
		Queue<Node> q = new ArrayDeque<>();  // 별도의 배열을 두지 않고 생성되는 값만 처리하도록 유동적인 자료형만 사용 -> 메모리 제한이 512인데 int * 10^9의 경우 메모리 초과
		q.offer(new Node(1, a));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			if(cur.value == b) {
				answer = cur.step;
				break;
			}
			long type_1 = cur.value * 2;
			long type_2 = Long.parseLong(String.valueOf(cur.value) + 1);
			for (long i : new long[] {type_1, type_2}) {  // 만들어지는 값들이 범위가 크기 때문에 long 타입으로 선언
				if(i <= b)  // 주어진 범위를 벗어나지 않는 선에서
					q.offer(new Node(cur.step + 1, i));  // 만들어진 값과 이전 값의 스탭을 갱신해서 새롭게 추가
			}
		}
	}
	
	static class Node {
		int step;
		long value;

		public Node(int pos, long value) {
			this.step = pos;
			this.value = value;
		}
	}
}
