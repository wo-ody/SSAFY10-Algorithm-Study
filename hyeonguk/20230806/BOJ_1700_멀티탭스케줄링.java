import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K, cnt;
	static int[] multiTab, multiTabNext ;
	static int[] inputs, inputsNext;
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		multiTab = new int[N];
		multiTabNext = new int[N];
		inputs = new int[K];
		inputsNext = new int[K];
		
		// 값 입력 받기 
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<K; i++) {
			inputs[i] = Integer.parseInt(st.nextToken());
		}
		
		//int num = 1;
		for(int i=0; i<K; i++) {
			for(int j=i+1; j<K; j++) {
				if(inputs[i] == inputs[j]) {
					inputsNext[i] = j;
					break;
				}
			}
		}
		
		for(int i=0; i<K; i++) {
			
			// 값이 들어있을 경우 건너뛰기 
			if(numInMultiTab(i)) continue;
			
			// 값이 들어있지 않을 경우 
			// 멀티탭에 꽂혀있는 용품 중 가장 나중에 쓰는 애를 찾고 카운트 증가 
			change(i);
		}
		System.out.println(answer);
	}
	
	// 멀티 탭에 꽂혀있는지 확인하는 메서드 
	static boolean numInMultiTab(int idx) {
		for(int i=0; i < N; i++) {
			if(multiTab[i] == inputs[idx]) {
				multiTabNext[i] = inputsNext[idx];
				return true;
			}
		}
		return false;
	}
	
	// 멀티 탭에 꽂힌 용품 중 가장 나중에 사용하는 용품 인덱스 위치 찾는 메서드 
	static void change(int idx) {
		// multiTabNext 가 0인 경우 바로 해당 자리에 넣기 
		for(int i=0; i<N; i++) {
			if(multiTabNext[i] == 0) {
				multiTab[i] = inputs[idx];
				multiTabNext[i] = inputsNext[idx];
        // 멀티탭이 비어있는 경우 answer 증가 안함
				if(cnt<N) {
					cnt++;
					return;
				}
				answer++;
				return;
			}
		}
		
		// multiTabNext가 0이 아닌경우 거리가 가장 먼 자리에 넣기 
		int tmpValue = multiTabNext[0];
		int tmpIdx = 0;
		for(int i=1; i<N; i++) {
			if (tmpValue < multiTabNext[i]) {
				tmpValue = multiTabNext[i];
				tmpIdx = i;
			}
		}
		
		multiTab[tmpIdx] = inputs[idx];
		multiTabNext[tmpIdx] = inputsNext[idx];
		answer++;
	}
}
