package practice.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11651 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int x, y;
		Cord[] arr = new Cord[n];  // 좌표 객체를 저장할 배열 생성
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			arr[i] = new Cord(x, y);  // 배열에 좌표 객체 저장
		}
		
		Arrays.sort(arr, (o1, o2) -> (o1.y != o2.y) ? o1.y - o2.y : o1.x - o2.x);  // 객체들의 y가 같지 않다면 y기준 오름차순, 같다면 x기준 오름차순 
		for (Cord answer : arr)   // 정렬된 좌표들을 저장
			sb.append(answer);
		
		System.out.println(sb);
	}
	
	static class Cord {  // x, y 좌표를 저장할 클래스
		int x, y;
		Cord(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {  // 정답 포맷을 맞추기 위한 메서드 오버라이딩
			return x + " " + y + "\n";
		}
	}
}

