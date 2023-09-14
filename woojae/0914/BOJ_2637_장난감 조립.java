import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m;
	static int x, y, k;
	static List<List<int []>> graph = new ArrayList<List<int[]>>();
	static int[] in_dgree;
	static int[][] assembly_info;
	static Queue<Integer> q = new ArrayDeque<Integer>();
	static int current_component;  // 현재 부품: y
	static int make_component;  // 현재 부품으로 만들 수 있는 부품: x
	static int amount;  // 부품을 만들기 위해 필요한 현재 부품의 수: k
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		for(int i = 0; i <= n; i++)
			graph.add(new ArrayList<>());
		in_dgree = new int[n + 1];
		assembly_info = new int[n + 1][n + 1];
		for(int i = 1; i <= m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			graph.get(y).add(new int[] {x, k});  // 부품 y는 부품 x를 만드는데 k개가 필요
			in_dgree[x]++;
		}
		tp_sort();
		for(int j = 1; j <= n; j++) if(assembly_info[n][j] != 0) sb.append(j).append(" ").append(assembly_info[n][j]).append("\n");
		System.out.println(sb);

	}
	
	static void tp_sort() {
		for(int i = 1; i <= n; i++)
			if(in_dgree[i] == 0)
				q.offer(i);
		
		while(!q.isEmpty()) {
			current_component = q.poll();
			for (int[] info : graph.get(current_component)) {
				make_component = info[0];
				amount = info[1];
				if(Arrays.stream(assembly_info[current_component]).sum() == 0)  // 기본 부품들은 다른 부품으로 만들 수 없으므로 다른 부품 정보가 모두 0
					assembly_info[make_component][current_component] += amount;  // 결과적으로 향후 기본 부품만 기록해서 사용하게 됨
				else {  // 중간 부품이라면
					for (int i = 1; i <= n; i++)  // 어떤 부품이 필요한지 모르니 전부 탐색
						assembly_info[make_component][i] += (assembly_info[current_component][i] * amount);
					// 중간 부품을 만들기 위해 필요한 기본 부품의 수를 알 필요가 있음
					// (해당 수량은 필요한 수량의 수) x (중간 부품을 만들기 위해 필요한 기본 부품의 수(이는 이미 해당 중간 부품에 기록되어 있다.))
					// 필요한 중간 부품을 만들기 위한 기본 부품(assembly_info[current_component][i]) x 필요한 중간 부품의 수(amount)
					// 예를 들어 7번 부품을 만드는데 5번 부품 2개가 필요하다면 7번 부품을 만들 때 필요한 기본 부품의 수는 5번 부품을 만드는 데 필요한 기본 부품의 수 x 2가 된다.
					// 또한 n번 부품이 완성 부품이므로 n번 부품에서 기본 부품에 해당하는 녀석들을 확인하면 된다.
				}
				in_dgree[make_component]--;
				if(in_dgree[make_component] == 0)
					q.offer(make_component);
			}
		}
	}
}
