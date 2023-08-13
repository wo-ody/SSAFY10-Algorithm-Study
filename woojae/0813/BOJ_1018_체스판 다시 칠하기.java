import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] board = new char[n][m];
		int w_cnt = 0, b_cnt = 0, answer = Integer.MAX_VALUE;
		int temp = 0;
		String[] check = { "WBWBWBWB", "BWBWBWBW" };

		for (int row = 0; row < n; row++) {  // 체스판 생성
			String line = sc.next();
			for (int col = 0; col < m; col++)
				board[row][col] = line.charAt(col);
		}

		for (int row = 0; row < n - 8 + 1; row++)  // 8 x 8 크기의 체스판으로 커팅, 가령 10 x 8짜리라면 2번만 커팅하면 됨
			for (int col = 0; col < m - 8 + 1; col++) {  // 좌표로 표시한다면 0 ~ 7, 1 ~ 8 -> 총 2번
				w_cnt = 0;  // 새로운 체스판을 커팅할 때마다 변수 초기화
				b_cnt = 0;
				for (int i = 0; i < 8; i++)  // 잘린 체스판 탐색, 가로 및 세로가 모두 8이라는 것을 상정
					for (int j = 0; j < 8; j++) {
						if (check[i % 2].charAt(j) != board[row + i][col + j])  // 일반적인 체스판은 check의 형태가 번갈아가며 반복됨
							w_cnt++;  // 동일하지 않을 때 흰색을 칠하든 검은색을 칠하든 중요하지 않음
						else
							b_cnt++;
					}
				temp = Math.min(w_cnt, b_cnt);  // 8 x 8 짜리 체스판의 탐색이 끝난 후 가장 적게 칠한 색을 선택
			answer = Math.min(temp, answer);  // 커팅된 체스판에 대한 탐색이 끝날 때마다 정답 갱신
			}
		System.out.println(answer);
	}
}
