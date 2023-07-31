import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//Edge: 연결된 노드들과 가중치 표시
class Edge implements Comparable<Edge> {
	int start;
	int end;
	int weight;

	Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

    //가중치를 판단
	@Override
	public int compareTo(Edge o) {
		return weight - o.weight;
	}

}

public class Main {
	static int[] parent;                //union-find용 변수
	static ArrayList<Edge> edgeList;    //간선 노드

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		edgeList = new ArrayList<>();
        //1. 노드 초기화
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
            
			edgeList.add(new Edge(start, end, weight));
		}

        //2. union-find 초기화
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

        //3. 크루스칼
        //3-1. 모든 간선을 거리 기준으로 정렬
		Collections.sort(edgeList);

		int ans = 0;
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			//3-2. Union-Find (사이클이 발생하는 간선은 제외.)
			if (find(edge.start) != find(edge.end)) {
				ans += edge.weight;
				union(edge.start, edge.end);
			}
		}

        //4. 출력
        System.out.println(ans);
		br.close();
	}

    //x가 어떤 집합에 포함되어 있는지 찾는 연산
	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

    //x와 y가 포함되어 있는 집합을 합치는 연산
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}

}