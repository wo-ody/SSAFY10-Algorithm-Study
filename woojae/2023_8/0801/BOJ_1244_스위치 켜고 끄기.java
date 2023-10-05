import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 스위치 생성
		int switch_num = Integer.parseInt(br.readLine());
		boolean[] switch_arr = new boolean[switch_num + 1];
		
		// 스위치 초기화
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < switch_num + 1; i++)  // 편의를 위해 0번째에 더미 공간 할당
			switch_arr[i] = st.nextToken().equals("1") ? true : false;  // 표현이 쉽도록 boolean으로 선언
		
		// 학생 정보 생성
		int student_num = Integer.parseInt(br.readLine());
		int[][] student_info = new int[student_num][2];
		
		// 학생 초기화
		for(int i = 0; i < student_num; i++) {
			st = new StringTokenizer(br.readLine());
			student_info[i][0] = Integer.parseInt(st.nextToken());
			student_info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 메인 로직
		for (int[] student : student_info) {
			if(student[0] == 1) {  // 남학생이라면
				for(int i = student[1]; i < switch_num + 1; i += student[1])  // 배수의 스위치 토글
					switch_arr[i] = !switch_arr[i];
			}
			else {
				int cur = student[1];
				int d = 1;
				switch_arr[cur] = !switch_arr[cur];  // 대칭이던 아니던 자기 자신은 무조건 토글됨
				while(0 < cur - d && cur + d < switch_num + 1) {  // 범위를 늘려가며 대칭 스위치 탐색
					if(switch_arr[cur - d] == switch_arr[cur + d]) {  // 대칭인 스위치들 토글
						switch_arr[cur - d] = !switch_arr[cur - d];
						switch_arr[cur + d] = !switch_arr[cur + d];
						d++;
					}
					else  // 대칭이 아니라면 탐색 종료
						break;
				}
			}
		}
		for(int i = 1; i < switch_num + 1; i++) {
			System.out.print(((switch_arr[i]) ? 1 : 0) + " ");
			if(i % 20 == 0)  // 20이 넘어갈 경우 개행
				System.out.println();
		}
	}
}
