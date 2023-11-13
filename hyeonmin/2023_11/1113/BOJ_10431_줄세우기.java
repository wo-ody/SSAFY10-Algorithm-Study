package month11.day13;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_10431_줄세우기 {

	static int T;
	static int[] line;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken(); // 테케 번호는 t로 계산하면 되기 때문에 버린다.
			
			line = new int[20];
			
			line[0] = Integer.parseInt(st.nextToken()); // 첫번째 학생이 줄을 선다.
			
			int sum = 0;
			
			// 다음 19명의 학생이 들어오면서 자기 자리를 찾아 간다.
			for (int i = 1; i < 20; i++) {
				int student = Integer.parseInt(st.nextToken());
				int index = findIndex(student);
				line[i] = student;
				
				// 가야할 자리가 존재하면 index가 -1이 아니다.
				if(index != -1) {
					// 학생들을 밀어내러 간다.
					// 밀어낸 횟수 : i(원래들어가야 하는 자리) - index(밀어내면서 가야하는 자리)
					goIndex(i, index);
					sum += (i - index);
				}
			}
			sb.append(t).append(" ").append(sum).append("\n");
			
			// 1. 다음 학생이 들어가야할 자리의 index를 구한다.
			// 2. 그 index까지 몇칸 이동해야하는지 구한다.
			// 3. 모든 과정을 반복하며 이동회수를 합산한다.
		}
		System.out.println(sb);
		
	}
	
	static void goIndex(int start, int end) {
		int temp = line[start];
		for (int i = start; i > end; i--) {
			line[i] = line[i-1];
		}
		line[end] = temp;
	}
	
	static int findIndex(int student) {
		for(int i = 0; i < 20; i++) {
			if (line[i] > student) return i;
		}
		return -1; // 앞으로 갈 필요가 없다면 -1 return
	}

}
