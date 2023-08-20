import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 블록 제거 2초
	 * 블록 설치 1초
	 * 땅고르기 최소 시간, 그때 높이 -> 평평화 작업 끝났을 때의 높이
	 * 초기 인벤토리 블록 B가 주어짐, 땅의 높이는 256을 초과할 수 없으며 음수도 불가능*/
	static int put_time = 1;  // 설치 시간
	static int destruct_time = 2;  // 파괴 시간
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		int inventory_blocks, check_time;
		int	height = 0, time = Integer.MAX_VALUE;
		int max_h = 0, min_h = 256;
		
		for(int i = 0; i < n; i++) {  // 맵 초기화
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max_h = max_h < map[i][j] ? map[i][j] : max_h;  // 맵의 최소 및 최대 높이를 입력받음과 동시에 갱신
				min_h = min_h > map[i][j] ? map[i][j] : min_h;
			}
		}
		// 기준 높이에 맞춰 다 부수거나 쌓는 방식으로 최적의 답을 찾아나감
		for(int h = min_h; h <= max_h; h++) {  // 최소 ~ 최대의 높이
			check_time = 0;  // 각 상황마다 어떤 것이 최선인지 모르므로 기준 높이가 갱신될 때마다 값 초기화
			inventory_blocks = b;  // 사용할 수 있는 블록
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(h < map[i][j]) {  // 기준 높이가 현재 구역의 블록보다 낮다면
						check_time += (map[i][j] - h) * destruct_time;  // 해당 차이만큼 블록 파괴
						inventory_blocks += (map[i][j] - h);  // 파괴된 블록은 인벤토리에 추가
					}
					else if(h > map[i][j]) {  // 기준 높이가 현재 구역의 블록보다 높다면
						check_time += (h - map[i][j]) * put_time;  // 해당 차이만큼 블록 설치
						inventory_blocks -= (h - map[i][j]);  // 설치한 만큼 인벤토리의 블록 감소
					}
				}
			}
			
			if(inventory_blocks > -1 && check_time <= time) {  // 블록이 유효 범위이고 해당 기준 높이에서의 작업 시간이 최소라면
				// 인벤토리의 블록이 0보다 작다는 것은 주어진 자원에서 초과하여 사용했다는 의미로 성립할 수 없는 상황임
				time = check_time;  // 최소 작업 시간으로 갱신
				height = height < h ? h : height;  //  답이 여러 개(최소가 여러 개)일 때 가장 높은 땅의 높이를 반환해야 하므로
			}
		}
		System.out.println(time + " " + height);
	}
}