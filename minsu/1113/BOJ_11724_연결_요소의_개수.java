import java.util.*;
import java.io.*;

public class Main {
	static int arr[][];
	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 정점의 개수
		int M = Integer.parseInt(st.nextToken()); // 간선의 개수

		arr = new int[N+1][N+1];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			// 무방향 그래프 특성.
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		floyd();

		int count = 0;
		boolean node[] = new boolean[N+1];
		for(int i=1; i<=N; i++) {

			// 이미 등록된 노드는 탐색할 필요없음
			if(node[i] == true) {                             >                             
				continue;
			}

			for(int j=1; j<=N; j++) {
				if(arr[i][j] == 1 && node[j] == false) {
					node[j] = true;
				}
			}

			count ++;
		}

		System.out.println(count);

	} // End of main

	static void floyd() {

		for(int k=0; k<=N; k++) {
			for(int i=0; i<=N; i++) {
				for(int j=0; j<=N; j++) {

					if(arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					}
				}
			}
		}

	} // End of floyd

} // End of class
