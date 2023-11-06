package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1027 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int[] buildings;
	static int answer = 0;
	
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		buildings = new int[n];
		
		for(int i = 0; i < n; i++)
			buildings[i] = Integer.parseInt(st.nextToken());
		
		solve();
		System.out.println(answer);
	}
	
	static void solve() {
		for(int i = 0; i < n; i++) {  // 각 건물마다 기울기 체크
			double current_gradient = 0, temp = 0;
			int cnt = 0;
			for(int j = i-1; j >= 0; j--) {  // 왼쪽 탐색
				temp = cal_gradinet(i, j, buildings[i], buildings[j]);
				if(j == i-1 || temp < current_gradient) {  // 바로 왼쪽 건물은 확정적으로 보임, 왼쪽의 기울기들은 항상 양의 기울기이면서 기울기가 낮아져야 보이는 건물이 됨
					current_gradient = temp;
					cnt++;
				}
			}
			for(int j = i+1; j < n; j++) {  // 오른쪽 탐색
				temp = cal_gradinet(i, j, buildings[i], buildings[j]);  // 위 조건과 마찬가지
				if(j == i+1 || temp > current_gradient) {
					current_gradient = temp;
					cnt++;
				}
			}
			answer = Math.max(cnt, answer);
		}
	}
	
	static double cal_gradinet(double x1, double x2, double y1, double y2) {
		return (y2 - y1) / (x2 - x1);  // 기울기 = y 증가량 / x 증가량
	}
}
