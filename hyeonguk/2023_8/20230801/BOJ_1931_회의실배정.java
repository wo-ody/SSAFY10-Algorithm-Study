import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] roomList = new int[N][2];
		
		// 값 입력 받기
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			roomList[i][0] = Integer.parseInt(st.nextToken());
			roomList[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 입력 받은 값 오름차순으로 정렬하기.(두번째 기준 오름차순한 후 첫번째 기준 오름차순)
		Arrays.sort(roomList, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				 return o1[1]==o2[1] ? (o1[0]==o2[0] ? o2[0]-o1[0] : o1[0]-o2[0]) : o1[1]-o2[1];
			}
		});
		
		int answer = 0;
		int time = 0;
		for(int i=0; i<N; i++) {
			if(roomList[i][0] >= time) {
				time = roomList[i][1];
				answer++;
			}
		}
		
		System.out.println(answer);
		
	}
	
}
