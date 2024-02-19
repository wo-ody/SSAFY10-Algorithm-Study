package bj.G4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
1. 비용을 오름차순으로 정렬시켜준 후, 제일 비용이 적은거부터 연결을 해준다
2. 이때, 사이클이 생기면 안됨!! 1->2 , 2->3 이렇게 되어 있는 상태라면 1->3을 연결하면 안됨
 */
public class BOJ_1922_네트워크연결 {
	static int n; // 컴퓨터의 수
	static int m; // 연결할 수 있는 선의 수
	static int[][] network; // 각 컴퓨터가 연결된 정보들
	static StringTokenizer st;
	static int costs;
	static int[] arr; // 어디에 연결되어 있는지 확인하기 위한

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());

		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		network = new int[m][3];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			network[i][0] = Integer.parseInt(st.nextToken());
			network[i][1] = Integer.parseInt(st.nextToken());
			network[i][2] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(network, Comparator.comparing(o -> o[2])); // 비용을 기준으로 오름차순 정렬

//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < 3; j ++) {
//                System.out.print(network[i][j]);
//            }
//            System.out.println();
//        }

		for (int[] net : network) {
			if (union(net[0], net[1])) {
				costs += net[2];
			}
//            System.out.println(Arrays.toString(arr));
		}
		System.out.println(costs);
	}

	static int find(int x) { // 연결되었다면 끝지점이 어디인지 탐색
		if (arr[x] == x) {
			return x;
		}
		return find(arr[x]);
	}

	static boolean union(int start, int end) {
		int s = find(start);
		int e = find(end);

		if (s != e) {
			arr[e] = s;
			return true;
		}
		return false;
	}
}
