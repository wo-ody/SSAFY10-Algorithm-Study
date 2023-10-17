import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, k;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[100001];
		solve();
	}
	
	static void solve() {
		Deque<Integer> q = new ArrayDeque<>();
		q.offer(n);
		
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x == k) {
				System.out.println(arr[x]);
				break;
			}
			for (int i : new int[] {x-1, x+1, 2*x}) {
				if(0 <= i && i <= 100000 && arr[i] == 0) {
					if(x != 0 && i == 2*x) {  // x가 0이면 무한 루프에 빠짐 -> 2*x는 항상 0이며, 해당 조건일 때 항상 큐의 앞에 삽입되기 때문
						// 직관적으로 생각하면 0인 위치에서 아무리 2배에 해당하는 위치로 순간이동해도 계속 0으로 돌아올 뿐
						arr[i] = arr[x];
						q.addFirst(i);  // 일반적으로 생각했을 때, 순간이동하는 것이 비용 없이 거리를 이동하는 것이기 때문에 우선 고려되어야 함
					}
					else {
						arr[i] = arr[x] + 1;
						q.addLast(i);
					}
				}
			}
		}
	}
}
