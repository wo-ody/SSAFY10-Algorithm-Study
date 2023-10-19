package month10.day19;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_1522_문자열교환 {
	
	static int aLen, cnt, min;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int size = str.length();
		aLen = 0;
		
		// a의 개수만큼 슬라이딩 윈도우를 만든다.
		
		arr = new int[size];
		for (int i = 0; i < size; i++) {
			int value = str.charAt(i) - 'a';
			arr[i] = value; // a:0, b:1
			if(value==0) aLen++; // 윈도우 길이++
		}
		
		// 1. 0부터 size-1 까지 b의 개수를 cnt에 저장
		// 2. 오른쪽으로 한칸 이동(0이 b이면 cnt-1, size가 b이면 +1
		// 3. min값 갱신
		// 4. 이 모든걸 size 번 반복 (인덱스가 size 넘어가면 %size 해주면 됨)
		
		// 첫번째 윈도우 안에 b의 개수를 센다
		for (int i = 0; i < aLen; i++) {
			cnt+=arr[i]; // b의 개수
		}
		
		min = cnt;
		// 완탐
		for (int i = 1; i < size; i++) {
			// 2
			int nextEnd = (i+aLen-1) % size;
			cnt -= arr[i-1]; // 벗어난 값이 b이면 -1
			cnt += arr[nextEnd]; // 들어온 값이 b이면 +1
			
			// 3
			min = Math.min(min, cnt);
		}
		
		// 정답 출력
		System.out.println(min);
		
	}
}
