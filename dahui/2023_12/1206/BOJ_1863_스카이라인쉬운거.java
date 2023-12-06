package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//중간에 더 낮은 건물이 나온다면 해당 높이보다 높은 경우 건물은 카운트 해야함. 
public class BOJ_1863_스카이라인쉬운거 {
	static int n, ans;
	static StringTokenizer st;
	static Deque<Integer> stack = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int y = Integer.parseInt(st.nextToken());
			
			while(true) {
				if(stack.isEmpty()&&y!=0) {
					stack.push(y);
					break;
				}else if(y!=0){
					int py = stack.poll();
					if(py > y) {
						ans++;
					}else if(py<y) {
						stack.push(py);
						stack.push(y);
						break;
					}else {
						stack.push(py);
						break;
					}
				}else {
					ans += stack.size();
					stack.clear();
					break;
				}
			}
		}
		
		ans += stack.size();

		
		System.out.println(ans);
	}

}
