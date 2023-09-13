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
	static int n;
	static List<List<Integer>> graph = new ArrayList<List<Integer>>();
	static Queue<Integer> q = new ArrayDeque<Integer>();
	static int[] indgree;
	static int[] time_table;
	static int[] cost;
	static int time;
	static int work_num;
	static int answer = 0;
	static int previous;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		graph.add(new ArrayList<Integer>());
		indgree = new int[n + 1];
		time_table = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			graph.add(new ArrayList<Integer>());
			st = new StringTokenizer(br.readLine());
			time = Integer.parseInt(st.nextToken());
			work_num = Integer.parseInt(st.nextToken());
			time_table[i] = time;
			for(int j = 0; j < work_num; j++) {
				previous = Integer.parseInt(st.nextToken());
				graph.get(previous).add(i);
				indgree[i]++;
			}
		}
		cost = time_table.clone();  // 초기에는 time_table과 동일함
		tp_sort();
		System.out.println(answer);
	}
	
	static void tp_sort() {
		for(int i = 1; i <= n; i++)  // 기본적인 위상 정렬 코드 - 초기화
			if(indgree[i] == 0)
				q.offer(i);
		
		while(!q.isEmpty()) {  //  기본적인 위상 정렬 - 갱신
			previous = q.poll();  // 진입차수가 없어진 노드 제거
			for (Integer current : graph.get(previous)) {
				indgree[current]--;  // 연결된 노드가 하나 없어졌으므로 연결된 진입차수 정보 감소
				cost[current] = Integer.max(cost[current], cost[previous] + time_table[current]);
				// 실질적인 해당 문제의 메인 로직
				// 서로 선행 관계가 없는 작업들은 동시에 수행 가능하다는 제약이 있으므로 동시에 시작할 수 있는 작업 중 최대인 작업을 선택해야 해당 작업들을 모두 최소 시간으로 처리 가능
				// 그렇게 하지 않으면 논리적으로 처리 불가
				// 현재 업무를 처리했을 때 시간 = 현재까지 갱신된 시간 + 지금까지 소요된 시간 + 현재 업무의 소요 시간
				// 가령 다음과 같은 입력이 들어왔을 때
				// 4
				// 5 0
				// 1 1 1
				// 6 1 1
				// 1 2 2 3
				// 마지막 노드는 두 업무에 대해 영향을 받음
				// 해당 업무들의 시간을 처리하는데 max를 처리하지 않고 각각 처리하게 되면 13이 되지만
				// max를 사용해서 동시에 시작하는 업무 처리를 구현할 경우 12가 돼서, 결과적으로 최소 시간이 됨
				if(indgree[current] == 0) {  // 진입차수가 감소되어서 연결된 진입차수가 없다면
					q.offer(current);  // 해당 노드와 연결된 노드들을 탐색하기 위에 노드에 저장
				}
			}
		}
		
		for (int i : cost)  // 배열의 값 중 어떤 값이 최대인지 모르므로
			answer = answer < i ? i : answer;
	}
}
