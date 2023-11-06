/*
static void solve() {  // 초기 원본 배열과 정답 배열 두 가지를 생성해서 해결한 풀이 - 결과적으로 유의미한 메모리 차이는 없었음
		row = 1;
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < row; j++) {
				arr[i+1][j] = Math.max(origin[i+1][j] + arr[i][j], arr[i+1][j]);
				arr[i+1][j+1] = Math.max(origin[i+1][j+1] + arr[i][j], arr[i+1][j+1]);
        // 현재 값은 다음 층의 값과 다음 층의 오른쪽 값에 영향을 줌, 다만 여러 값에 영향을 받는 값의 경우 원본 값을 덮어씌우므로 가장 큰 값이 될 수 있는 가능성을 고려하지 못하는 Greedy한 풀이가 되므로 오답이 됨
        // 그렇기에 원본 값을 기록해서 이미 갱신되어 있는 값과 원본 값에 현재 값을 더한 값 중 큰 값을 선택하는 방식으로 풀이
				answer = Math.max(Math.max(arr[i+1][j], arr[i+1][j+1]), answer);
			}
			row++;
		}
		answer = n == 1 ? origin[0][0] : answer;
	}
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[][] arr;
	static int row;
	static int answer;

	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		row = 1;
		answer = -1;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < row; j++)
				arr[i][j] = Integer.parseInt(st.nextToken());
			row++;
		}
		solve();
		System.out.println(answer);
	}
	
	static void solve() {  // 별도의 원본 배열을 만들지 않는 풀이
		row = 2;
		for(int i = 0; i < n-1; i++) {  // 현재 값 기준으로 다음 층의 값 계산
			for(int j = 0; j < row; j++) {  // 1층을 기준으로 보지만 2층의 값을 계산하므로 row = 2부터 시작
				if(j == 0)
					arr[i+1][j] += arr[i][j];  // 다음 층의 첫 값은 바로 윗층의 첫 값만 영향을 받음
				else if(j == row - 1)
					arr[i+1][j] += arr[i][j-1];  // 다음 층의 마지막 값은 바로 윗층의 마지막 값(윗층의 마지막 값은 한 칸 왼쪽에 존재)만 영향을 받음
				else  // 측면의 값이 아닌 경우
					arr[i+1][j] += Math.max(arr[i][j-1], arr[i][j]);  // 다음 층의 값은 바로 위와 바로 위 왼쪽 대각선의 값에 영향을 받음, 그 중 최대를 선택
				answer = Math.max(arr[i+1][j], answer);  // 값이 계산될 때마다 값 확인 후 갱신
			}
			row++;
		}
		answer = n == 1 ? arr[0][0] : answer;  // 층이 1인 경우 값이 하나므로 해당 값 출력
	}
}
