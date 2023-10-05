import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][2];
		int[] answer = new int[n];
		Stack<int[]> s = new Stack<int[]>();
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i][0] = i;  // 위치
			arr[i][1] = Integer.parseInt(st.nextToken());  // 값
		}
		
		for(int i = 0; i < n; i++) answer[i] = -1;
		
		for(int i = 0; i < n; i++) {
			while(!s.isEmpty()) {
				if(s.peek()[1] < arr[i][1]) {  // 상단의 값과 현재 값을 비교해서 현재 값이 더 크다면
					int pos = s.pop()[0];  // s.pop() = 위치
					answer[pos] = arr[i][1];  // 오큰수로써 뽑은 위치에 값 저장
				}
				else break;  // 위 조건이 아닐 때 종료 조건을 걸지 않으면 무한 루프에 빠짐
			}
			s.push(arr[i]);  // 위치 저장
		}
		
		for (int i : answer) sb.append(i).append(" ");
		System.out.println(sb);
	}
}
