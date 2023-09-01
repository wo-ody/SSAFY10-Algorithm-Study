/*
 *  09.01 김창희
 *  BOJ_4195_친구네트워크
 *
 *  [풀이]
 *  1. union find할때 마다 합병하는 반대쪽으로 가중치를 더해준다.
 *  2. 근데 왜 합병할때 대소비교를 하여 넣으면 안되는지 모르겠다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static Map<String, Integer> map = new HashMap<>();
	static int[] parent;
	static int[] sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder answer = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= t; tc++) {

			int n = Integer.parseInt(br.readLine());
			map.clear();
			parent = new int[n * 2];
			sum = new int[n * 2];
			for (int i = 0; i < n * 2; i++)
				parent[i] = i;
			int index = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String f1 = st.nextToken();
				String f2 = st.nextToken();

				int x = 0, y = 0;

				if (map.containsKey(f1)) {
					x = map.get(f1);
				} else {
					x = index;
					sum[index]=1;
					map.put(f1, index++);
				}

				if (map.containsKey(f2)) {
					y = map.get(f2);
				} else {
					y = index;
					sum[index]=1;
					map.put(f2, index++);
				}

				if (findParent(x) != findParent(y)) {
					union(x, y);
				}

				int start = Math.min(findParent(x), findParent(y));
				answer.append(sum[start]).append("\n");
			}
		}
		System.out.println(answer);
	}

	public static void union(int x, int y) {
		x = findParent(x);
		y = findParent(y);

		if(x!=y) {
			parent[y]=x;
			sum[x]+=sum[y];		
		}
	}

	public static int findParent(int x) {
		if (x == parent[x])
			return x;
		return parent[x] = findParent(parent[x]);
	}
}
