import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cntWhoKnowTrues, answer;
	static int[] parents;
	static List<Integer> menWhoKnowTrues;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		parents = new int[N+1];
		for(int i=1; i<=N; i++) {
			parents[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		cntWhoKnowTrues = Integer.parseInt(st.nextToken());
		menWhoKnowTrues = new ArrayList<>();
		if (cntWhoKnowTrues != 0) {
			for (int i = 1; i <= cntWhoKnowTrues; i++) {
				menWhoKnowTrues.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		List<Integer>[] parties = new ArrayList[M];
		for(int i=0; i<M; i++) {
			parties[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int cntPeople = Integer.parseInt(st.nextToken());
			
			int x = Integer.parseInt(st.nextToken());
			parties[i].add(x);
			for(int j=1; j<cntPeople; j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x, y);
				parties[i].add(y);
			}
		}
		
		
		for(int i=0; i<M; i++) {
			boolean check = true;
			for(int person : parties[i]) {
				if(menWhoKnowTrues.contains(find(parents[person]))) {
					check = false;
					break;
				}
			}
			
			if(check) {
				answer++;
			}
		}
		
		
		System.out.println(answer);

	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		
		return parents[x] = find(parents[x]);
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(menWhoKnowTrues.contains(y)) {
			int tmp = x;
			x = y;
			y = tmp;
		}

		parents[y] = x;
	}
}
