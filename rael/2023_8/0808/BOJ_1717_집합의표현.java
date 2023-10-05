package BOJ1717;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int[] set;
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		set = new int[N+1];
		
		for(int i=0; i<N+1; i++) {
			set[i] = i;
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int opt = Integer.parseInt(st.nextToken());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			
			//합집합
			if(opt == 0) {
				union(n1, n2);
			}
			//여부 확인
			else if(opt == 1) {
				int n1_p = find(n1);
				int n2_p = find(n2);
				
				if(n1_p == n2_p) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	
	//부분 집합은 Union-Find로 구현 가능하다.
	//각 집합의 부모 값을 얻어와 한쪽 부모가 다른쪽 부모를 가르키게 함
	public static void union(int a, int b) {
		int ap = find(a);
		int bp = find(b);
		set[bp] = ap;
	}
	
	//원소가 속해있는 집합의 부모를 찾는 연산. 
	//A,B의 부모를 구했을 때, 같은 부모를 가르키면 같은 집합. 아니면 다른 집합.
	//연산속도 향상을 위해 자식노드 -> 부모노드 가리키도록.
	public static int find(int x) {
		if(x == set[x]) return set[x];
		else return set[x]=find(set[x]);	//부모 찾으면 최상위 부모로 업데이트
	}
}
