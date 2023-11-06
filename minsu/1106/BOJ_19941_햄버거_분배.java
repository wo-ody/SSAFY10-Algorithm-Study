package bj.S3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 원래는 List에 햄버거의 위치 인덱스를 담고 contains로 했다가 시간초과 발생
 * 입력받은 문자열을 배열로 바꿔서 햄버거 찾으면 해당 문자열을 E로 변경시키도록 코드 수정
 */
public class BOJ_19941_햄버거_분배 {
	static int N, K, answer;
	static char[] table;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		table = br.readLine().toCharArray();
		
		outer:for (int i = 0; i < N; i++) {
			// 사람을 찾아서
			// 찾으면 왼쪽부터 K만큼 탐색, 그러고 오른쪽으로 K만큼 탐색하면서 H를 찾으면 E로 문자열을 바꿔주고 다음 사람을 찾아서 
			if (table[i] == 'P') {
				// 왼쪽부터 
				for (int j = i - K; j < i; j++) {
					if (j < 0) {
						continue;
					}
					
					if (table[j] == 'H') {
						answer++;
						table[j] = 'E';
						continue outer;
					}
				}
				// 오른쪽 탐색
				for (int j = i + 1; j < i + K + 1; j++) {
					if (j >= table.length) {
						break;
					}
					
					if (table[j] == 'H') {
						answer++;
						table[j] = 'E';
						break;
					}
				}
			}

		}
		System.out.println(answer);
		
	}
}
