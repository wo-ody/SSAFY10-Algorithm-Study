import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int T, K, M, P;
	static int[] rivers;
	static int[] strahlerOrder;
	static Queue<Integer> queue; 
	static PriorityQueue<Integer>[] pq;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			rivers = new int[M+1];
			
			list = new ArrayList[M+1];
			pq = new PriorityQueue[M+1];
			for(int i=1; i<=M; i++) {
				list[i] = new ArrayList<>();
				pq[i] = new PriorityQueue<>((o1, o2) -> {return o2-o1;});
			}
			
			for(int i=0; i<P; i++) {
				 st = new StringTokenizer(br.readLine());
				 int start = Integer.parseInt(st.nextToken());
				 int end = Integer.parseInt(st.nextToken());
				 list[start].add(end);
				 rivers[end]++;
			}
			
			strahlerOrder = new int[M+1];
			queue = new ArrayDeque<>();
			for(int i=1; i<=M; i++) {
				if(rivers[i]==0) {
					queue.offer(i);
					strahlerOrder[i] = 1;
					pq[i].offer(1);
				}
			}
			
			while(!queue.isEmpty()) {
				int now = queue.poll();
				
				int size=list[now].size();
				for(int i=0; i<size; i++) {
					int next = list[now].get(i);
					rivers[next]--;
					pq[next].offer(strahlerOrder[now]);
					if(rivers[next]==0) {
						countStrahlerOrder(next);
						queue.offer(next);
					}
				}
			}

			sb.append(K).append(" ").append(strahlerOrder[M]).append("\n");
		}
		System.out.println(sb);
	}
	
	// 입력 값으로 들어온 현재 강에 대하여 strahler 순서를 계산한다.
	static void countStrahlerOrder(int now) {
        if(pq[now].isEmpty()) return;
		int cnt=0;
		int max = pq[now].peek();
		while(!pq[now].isEmpty()) {
			int num = pq[now].poll();
			if(num==max) {
				cnt++;
			}
			else {
				break;
			}
		}
		
		if(cnt>1) {
			strahlerOrder[now] = max+1;
		}else {
			strahlerOrder[now] = max;
		}
	}
}
