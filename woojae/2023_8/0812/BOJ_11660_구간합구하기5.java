import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 각 좌표에 원점으로부터의 좌표 까지의 사각형 영역의 합을 미리 계산
public class BOJ_11660_구간합구하기5 {
	static int N, M;
	static int[][] accu; // 각 행별 열의 누적합을 미리 계산, 다른 행과는 무관, 자신 행의 열이 1-> N 까지 누적합을 기록
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		// 원점으로부터 i, j까지의 영역의 합 계산 및 기록
		accu = new int[N+1][N+1];  // 초기 값들의 누적은 이전 좌표가 없기 때문에 더미 좌표들을 추가해서 계산해줘야 함
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++)
				accu[i][j] = accu[i-1][j] + accu[i][j-1] - accu[i-1][j-1] + Integer.parseInt(st.nextToken());
			// 2차원 형태의 누적은 현재 좌표 + 현재 좌표를 기준으로 한 가로(->, 열) + 세로(->, 행) 방향에 위치한 직전 값들의 합으로 구성
			// 이 각 방향의 누적 과정에서 이전 값의 영향을 서로 주고 받기 때문에 필연적으로 현재 위치에서 x-1, y-1 위치에 해당하는 값이 중복으로 누적됨: 각 방향으로 누적하는 과정에서 각각 해당 값이 더해졌으므로 
			// 그렇기 때문에 대각선에 위치한 중복된 값을 한 번 제거해줘야 함
		}
		
		// M 횟수만큼 계산
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 입력된 좌표를 행-열별로 처리
			int x1 = Integer.parseInt(st.nextToken()); int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken()); int y2 = Integer.parseInt(st.nextToken());
			sb.append(accu[x2][y2] - accu[x1-1][y2] - accu[x2][y1-1] + accu[x1-1][y1-1]).append("\n");
			// 주어진 좌표에서의 누적합은 (1, 1) ~ (x2, y2) = 전체 영역(누적되었으므로 결과적으로 (x2, y2)) - 주어진 좌표에서 제외된 좌표들의 합(= 행방향 및 열방향)을 빼주면 됨
			// 다만 제외한 좌표들의 누적합들을 빼주는 과정에서 중복되는 값이 전부 빼지므로 입력과는 반대로 한 번 더해줘야홤 -> (x1 -1, y1 - 1)
			// 행방향의 합 = 즉 누적합이 위치하는 좌표는 (x1-1, y2)
			// 열방향의 합 = 즉 누적합이 위치하는 좌표는 (x2, y1-1)
		}
		System.out.println(sb.toString());
	}
}
