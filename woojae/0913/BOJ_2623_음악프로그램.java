import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n, m;  // 전체 가수 및 PD의 수
	static int singer_num;  // 입력받을 가수의 수
	static int previous_singer;  // 각 PD별 먼저 시작하는 가수
	static int singer; // 나머지 가수
	static int node; // 큐에서 제거한 가수
	static int[] indgree;
	static List<List<Integer>> graph = new ArrayList<List<Integer>>();
	static Queue<Integer> q = new ArrayDeque<Integer>();
	static List<Integer> result = new ArrayList<Integer>();
	
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		indgree = new int[n + 1];
		for(int i = 0; i <= n; i++)
			graph.add(new ArrayList<Integer>());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			singer_num = Integer.parseInt(st.nextToken());
			previous_singer = Integer.parseInt(st.nextToken());
			for(int j = 1; j < singer_num; j++) {  // 각 가수들 마다 순서가 존재하므로 처리해줘야 함
				singer = Integer.parseInt(st.nextToken());
				graph.get(previous_singer).add(singer);
				indgree[singer]++;
				previous_singer = singer;
			}
		}
		tp_sort();
		if(result.size() == n)  // 모든 탐색이 완료되었다면
			for (Integer i : result) System.out.println(i);
		else
			System.out.println(0);
	}
	
	static void tp_sort() {
		for(int i = 1; i <= n; i++)
			if(indgree[i] == 0)
				q.offer(i);
		
		while(!q.isEmpty()) {
			node = q.poll();
			result.add(node);
			for (Integer i : graph.get(node)) {
				indgree[i]--;
				if(indgree[i] == 0)
					q.offer(i);
			}
		}
	}
}
