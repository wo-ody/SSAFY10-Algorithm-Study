import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n;
	static int max = 0;
	static int[][] arr;
	static int answer = 0;
	public static void main(String[] args) throws IOException {
		n = Integer.parseInt(br.readLine());
		arr = new int[n][2];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			max = max < arr[i][0] ? arr[i][0] : max;
		}
		int[] schedule = new int[max + 1];  // 과제에 대한 최대 스케쥴, 마감 기한의 최소는 1이므로 인덱스를 맞추기 위해 더미 삽입
		Arrays.sort(arr, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);  // 동일 점수라면 마감일이 빠른 순으로, 그게 아니라면 점수가 높은 순으로 정렬
		for (int i = 0; i < n; i++) {
			if(schedule[arr[i][0]] == 0) {  // 해당 마감기한에 시작하려는 과제가 없다면
				schedule[arr[i][0]] = arr[i][1];  // 그에 해당하는 과제에 대한 점수 추가
				answer += arr[i][1];  // 점수 누적
			}
			else {  // 하지만 이미 과제가 있다면
				for(int j = arr[i][0]; j > 0; j--) {  // 마감기한들을 역으로 탐색하며
					if(schedule[j] == 0) {  // 가장 가까운 마감기한 탐색
						schedule[j] = arr[i][1];  // 과제에 대한 점수 추가
						answer += arr[i][1];  // 점수 누적
						break;  // 중복으러 덮어쓰는 것을 방지하기 위해 탐색 종료
					}
				}
			}
		}
		System.out.println(answer);  // 누적 점수 출력
	}
}
