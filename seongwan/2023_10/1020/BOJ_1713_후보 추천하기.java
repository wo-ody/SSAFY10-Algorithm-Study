import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, cnt, temp;
	static int[][] frame = new int[101][2];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			temp = Integer.parseInt(st.nextToken());
			if (cnt < N) {// 사진틀에 후보가 다 걸려있지 않은 상황
				if (frame[temp][0] > 0)
					frame[temp][0]++;
				else {
					cnt++;// 사진틀에 걸려 있는 후보 수 증가
					frame[temp][0]++;
				}
			} else {// 사진틀이 꽉 차 있을 떄
				if (frame[temp][0] > 0)// 사진틀에 있는 후보라면
					frame[temp][0]++;
				else {// 사진틀에 없는 후보라면
					delete();// 조건에 맞는 후보 삭제
					frame[temp][0]++;
				}
			}
			after();// 기간 증가
		}
		find();
		System.out.println(sb);
	}

	static void delete() {
		int del = 0;// 삭제할 대상
		int minr = Integer.MAX_VALUE;// 최소 추천횟수
		int old = 0;// 삭제할 대상의 후보 등록된 기간
		for (int i = 1; i <= 100; i++) {
			if (frame[i][0] == 0)
				continue;
			if (frame[i][0] < minr) {
				minr = frame[i][0];
				del = i;
				old = frame[i][1];
			} else if (frame[i][0] == minr) {
				if (frame[i][1] > old) {
					del = i;
					old = frame[i][1];
				}
			}
		} // 삭제할 대상 탐색
		frame[del][0] = 0;
		frame[del][1] = 0;// 삭제 처리
	}

	static void after() {
		for (int i = 1; i <= 100; i++) {
			if (frame[i][0] == 0)
				continue;
			frame[i][1]++;
		}
	}

	static void find() {
		for (int i = 1; i <= 100; i++) {
			if (frame[i][0] > 0)
				sb.append(i + " ");
		}
	}

}