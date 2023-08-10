import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_17298_오큰수 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] A = new int[N];	// 수열을 받는 배열
		int[] result = new int[N]; 	// 결과출력할 배열
		Deque<Integer> idxStack = new ArrayDeque<>(); // 수열의 인덱스를 핸들링해서 오큰수를 구할 스택
		idxStack.push(0); // 인덱스 비교를 시작하기 위해 첫번째 인덱스값을 스택에 push 해줌
		
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // 배열에 수열값을 받아 넣는다.
		}
		
		for (int i = 1; i < N; i++) {
			// [0]   [1]   [2]   [3]   [4]   [5]   [6]   [7]
			//  3     5     2     31    36    5     4     28
			
			// 계속반복한다 무슨조건? > 스택이 비어있지 않고, 현재 비교하는 값이 다음 값보다 작다면
			// 결국 스택의 최상위에는 항상 오큰수가 존재한다.
			while(!idxStack.isEmpty() && A[idxStack.peek()] < A[i]) {
				result[idxStack.pop()] = A[i];	// 정답 배열에 저장
			}
			idxStack.push(i);
		}
		
		while(!idxStack.isEmpty()) {
			result[idxStack.pop()] = -1;
		}
		for (int i = 0; i < N; i++) {
			bw.write(result[i] + " ");
		}
		br.close();
		bw.flush();
		bw.close();
		
		
	}

}







