import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class swea_4013_특이한자석 {
	static int T,K;
	static int[][] wheel = new int[4][8];
	
	//바퀴마다 회전해야 하는 방향 입력 ( 1 : 시계 , -1 : 반시계 , 0 : 움직이지 않음 )
	static int[] wheel_dir = new int[4];
	
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			K = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++) {
					wheel[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int wheel_num = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken());
				rotate(wheel_num, r);
			}
			
			// 점수 계산
			result = 0;
			get_result();
			
			// 출력
			System.out.println("#"+tc+" "+result);
		}
	}
	
	static void get_result() {
		if(wheel[0][0] == 1) result += 1;
		if(wheel[1][0] == 1) result += 2;
		if(wheel[2][0] == 1) result += 4;
		if(wheel[3][0] == 1) result += 8;
	}
	
	static void wheel_rotation(int idx, int r) {
		if(r == 1) {
			int last = wheel[idx][7];
			for (int i = 6; i >= 0; i--) {
				wheel[idx][i+1] = wheel[idx][i];
			}
			wheel[idx][0] = last;
		}
		else if(r == -1){
			int first = wheel[idx][0];
			for (int i = 1; i < 8; i++) {
				wheel[idx][i-1] = wheel[idx][i];
			}
			wheel[idx][7] = first;
		}
	}
	
	static void move_wheel() {
		for (int k = 0; k < 4; k++) {
			wheel_rotation(k,wheel_dir[k]);
		}
	}

	// N 과 S 극 합이 1 ---> 서로 다른 극이다
	static void rotate(int wheel_num, int r) {
		//wheel_dir 초기화
		wheel_dir = new int[4];
		
		//방향 넣기
		wheel_dir[wheel_num] = r;
		
		if(wheel_num == 0) {
			if((wheel[0][2] + wheel[1][6]) == 1) wheel_dir[1] = wheel_dir[0] * (-1);
			if(wheel_dir[1] != 0 && (wheel[1][2] + wheel[2][6]) == 1) wheel_dir[2] = wheel_dir[1] * (-1);
			if(wheel_dir[2] != 0 && (wheel[2][2] + wheel[3][6]) == 1) wheel_dir[3] = wheel_dir[2] * (-1);
		}
		else if(wheel_num == 1) {
			if((wheel[0][2] + wheel[1][6]) == 1) wheel_dir[0] = wheel_dir[1] * (-1);
			if((wheel[1][2] + wheel[2][6]) == 1) wheel_dir[2] = wheel_dir[1] * (-1);
			if(wheel_dir[2] != 0 && (wheel[2][2] + wheel[3][6]) == 1) wheel_dir[3] = wheel_dir[2] * (-1);
		}
		else if(wheel_num == 2) {
			if((wheel[1][2] + wheel[2][6]) == 1) wheel_dir[1] = wheel_dir[2] * (-1);
			if((wheel[2][2] + wheel[3][6]) == 1) wheel_dir[3] = wheel_dir[2] * (-1);
			if(wheel_dir[1] != 0 && (wheel[0][2] + wheel[1][6]) == 1) wheel_dir[0] = wheel_dir[1] * (-1);
		}
		else if(wheel_num == 3) {
			if((wheel[2][2] + wheel[3][6]) == 1) wheel_dir[2] = wheel_dir[3] * (-1);
			if(wheel_dir[2] != 0 && (wheel[1][2] + wheel[2][6]) == 1) wheel_dir[1] = wheel_dir[2] * (-1);
			if(wheel_dir[1] != 0 && (wheel[0][2] + wheel[1][6]) == 1) wheel_dir[0] = wheel_dir[1] * (-1);
		}
		
		// wheel_dir을 보고 회전시키기
		move_wheel();
	}
}
