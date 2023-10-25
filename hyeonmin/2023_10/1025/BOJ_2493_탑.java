package month10.day25;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493_탑 {

	static int N;
	static Stack<int[]> stack = new Stack<>();
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 1 <= N <= 50만
		N = Integer.parseInt(br.readLine());
		
		// 1. 스택에 넣기전에 변수에 저장
		// 2. 들어오려는 수가 스택 peek보다 높으면 peek는 pop해서 버린다.
		// 3. 또 peek를 확인한다. (계속 반복)
		// 4. 만약 peek보다 낮다면? 그 peek가 레이저가 닿은 곳이다.
		// 5. 더이상 peek를 확인할 필요 없고 변수에 저장했던 값을 스택에 넣어준다.
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			int top = Integer.parseInt(st.nextToken());
			// stack이 비었다면 peek를 확인할 필요가 없다.
			while(!stack.isEmpty()) {
				if( stack.peek()[1] < top ) {
					stack.pop();
				} else {
					// 레이저 닿음 바로 출력
					sb.append(stack.peek()[0]).append(" ");
					break;
				}
			}
			// stack이 비어있고 수신한 탑이 없으면 0 출력
			if(stack.isEmpty()) sb.append(0).append(" ");
			
			// 스택에 넣어준다.
			stack.push(new int[] {i, top});
		}
		
		System.out.println(sb);
		
	}

}
