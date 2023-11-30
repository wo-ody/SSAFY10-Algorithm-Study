package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_17140_이차원_배열과_연산 {
	static int rowSize, colSize;

	static int r, c, k;
	static int[][] arr;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		// R연산 : A의 모든 행에 대해 정렬을 수행. 행 >= 열의 개수인 경우 적용
		// C연산 : A의 모든 열에 대해 정렬. 행 < 열의 개수인 경우

		// 한 행 또는 열에 있는 수 정렬 : 각각의 수가 몇 번 나왔는지 -> count cort

		// 수의 등장 횟수가 커지는 순 . 그게 여러가지면 수가 커지는 순으로 정렬

		// 3 1 1
		// -> 3 이 1 번 1이 2번
		// 3 1 1 2
		// 3 이 1번 1이 2번 2가 1번
		// 2 1 3 1 1 2

		// 100개를 넘어가는 경우 처음 100개를 제외하고는 버린다.

		// 와 이거 뭐냐
		// 진짜 개어려운데

		// 아 무조건 진행되게 돼 있구나

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		k = Integer.parseInt(st.nextToken());

		arr = new int[100][100];
		rowSize = colSize = 3;

		// 100과 100이 넘어가면 더 이상 저장하지 않는다.

		// 처음엔 3x3이 저장된다.

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cntArr = new ArrayList<>();
		for (int j = 0; j <= 100; j++) {
			cntArr.add(new numCnt(j));
		} // 얘를 확인해

		while (cnt < 100 && arr[r][c] != k) {
			cnt++;

			if (rowSize <= colSize)
				methodR();
			else
				methodC();
		}

		if (arr[r][c] == k)
			System.out.println(cnt);
		else {
			System.out.println(-1);
		}

	}

	static ArrayList<numCnt> cntArr;

	public static class numCnt {
		int num, cnt;

		public numCnt() {

		}

		public numCnt(int num) {
			this.num = num;
			this.cnt = 0;
		}
	}

	public static void methodR() {
		// 연산을 진행하고 이걸 저장한 다음 rowSize를 바꿔줘야함
		rowSize = 0; // 초기화를 해줘야 정확한 사이즈를 알 수 있다.
		for (int i = 0; i < colSize; i++) { // 한줄씩 확인

			for (int j = 0; j <= 100; j++) {
				cntArr.get(j).cnt = 0; // 다시 초기화

			}
			cntArr.sort((o1, o2) -> {
				return o1.num - o2.num;
			}); // 처음 상태로 돌아오게

			int[] tmp = new int[100];

//			int [] cntArr = new int [100];

//			System.out.println(Arrays.toString(arr[i]));
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 0)
					continue; // 0이면 멈춤

				// 아니라면
//				System.out.println(colSize);
//				System.out.println(arr[i][j]);

				cntArr.get(arr[i][j]).cnt += 1;
//				cntArr[arr[i][j]] += 1; // 하나 세준다.

			}
			// 세는게 끝났다면
			// 정렬 먼저 해야겠지

			cntArr.sort((o1, o2) -> {

				return o1.cnt != o2.cnt ? o1.cnt - o2.cnt : o1.num - o2.num;
			}); // 정렬 후에는 cnt가 작은순, 같으면 num이 작은 순으로 정렬 될 것.
			int idx = 0;
			for (int c = 1; c <= 100; c++) {
				// 어차피 처음은 무조건 0,0이 저장돼 있을 것.
				// 하나씩 확인하면서 배열에다 저장할거야
//				if (cntArr.get(c).num == 0)
//					continue;
				if (cntArr.get(c).num != 0 && cntArr.get(c).cnt == 0)
					continue;// 0이라는 건 더 이상 볼 필요 없다는 뜻

				tmp[idx++] = cntArr.get(c).num;
				tmp[idx++] = cntArr.get(c).cnt;
				// 저장 끝
				if (rowSize < idx)
					rowSize = idx; // 가장 큰 사이즈를 저장할 것.
				if (idx == 100)
					break;
			}

			for (int c = 0; c < 100; c++) {
//				if (tmp[c] != 0) {
//					
//				}
				arr[i][c] = tmp[c]; // 0도 포함해서 들어가게 될 것.
			}

		}

//		System.out.println(colSize);
//		System.out.println(rowSize);
	}

	public static void methodC() {
		// 연산을 진행하고 이걸 저장한 다음 rowSize를 바꿔줘야함
		colSize = 0; // 초기화를 해줘야 정확한 사이즈를 알 수 있다.
		for (int i = 0; i < rowSize; i++) { // 한줄씩 확인

			for (int j = 0; j <= 100; j++) {
				cntArr.get(j).cnt = 0; // 다시 초기화

			}
			cntArr.sort((o1, o2) -> {
				return o1.num - o2.num;
			}); // 처음 상태로 돌아오게

			int[] tmp = new int[100];

//					int [] cntArr = new int [100];

			for (int j = 0; j < 100; j++) {
				if (arr[j][i] == 0)
					continue; // 0이면 멈춤

				// 아니라면
				cntArr.get(arr[j][i]).cnt += 1;
//						cntArr[arr[i][j]] += 1; // 하나 세준다.

			}
			// 세는게 끝났다면
			// 정렬 먼저 해야겠지

			cntArr.sort((o1, o2) -> {

				return o1.cnt != o2.cnt ? o1.cnt - o2.cnt : o1.num - o2.num;
			}); // 정렬 후에는 cnt가 작은순, 같으면 num이 작은 순으로 정렬 될 것.
			int idx = 0;
			for (int c = 1; c <= 100; c++) {
				// 어차피 처음은 무조건 0,0이 저장돼 있을 것.
				// 하나씩 확인하면서 배열에다 저장할거야
//						if (cntArr.get(c).num == 0)
//							continue;
				if (cntArr.get(c).num != 0 && cntArr.get(c).cnt == 0)
					continue;// 0이라는 건 더 이상 볼 필요 없다는 뜻

				tmp[idx++] = cntArr.get(c).num;
				tmp[idx++] = cntArr.get(c).cnt;
				// 저장 끝
				if (colSize < idx)
					colSize = idx; // 가장 큰 사이즈를 저장할 것.
				if (idx == 100)
					break;
			}

			for (int c = 0; c < 100; c++) {
//						if (tmp[c] != 0) {
//							
//						}
				arr[c][i] = tmp[c]; // 0도 포함해서 들어가게 될 것.
			}

		}
//		System.out.println(colSize);
//		System.out.println(rowSize);
	}
}
