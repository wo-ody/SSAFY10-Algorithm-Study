import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//pq에 값과 인덱스 그리고 버전을 같이 넣는다.
//N+1길이의 배열에 각 인덱스의 값의 버전을 관리하면서 최신 버전의 값을 확인한다
//예를 들어 처음 3번 인덱스에 4의 값이 들어갔을 때 4,3,0으로 버전 0으로 넣고
//다음에 3번 인덱스의 값이 5로 바뀌게 되면 5,3,1로 다음 버전의 수를 넣은 후
//배열에 3번 인덱스의 버전을 1로 기입하여 관리한다.
//pq에서 가장 작은 수 같으면 인덱스가 작은 수를 꺼내고 버전을 확인 후
//버전이 맞지 않다면 무시한다.
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		int[] version = new int[N + 1];

		//1번 쿼리 실행 시 버전 관리용
		int v = 1;
		PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) ->
			e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			pq.add(new int[] {Integer.parseInt(st.nextToken()), i, 0});
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int cmd = Integer.parseInt(st.nextToken());
			//1번 쿼리
			if (cmd == 1) {
				//새 값과 인덱스를 버전과 함께 pq에 넣은 후 version배열의 해당 인덱스에 최신 버전 기입
				int idx = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				pq.add(new int[] {value, idx, v});
				version[idx] = v++;
			}//2번 쿼리
			else {
				//최신 버전의 가장 작은 값이 나올 때까지 반복
				while (true) {
					int[] temp = pq.poll();
					int idx = temp[1];
					int ver = temp[2];

					//버전이 최신 버전이 아닌 경우
					if (ver != version[idx])
						continue;

					//가장 작은 값의 인덱스를 sb에 담은 후 다시 pq에 담음
					sb.append(idx + "\n");
					pq.add(temp);
					break;
				}
			}
		}
		System.out.println(sb);
	}
}