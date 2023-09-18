/*
 *	09.18 김창희
 *	BOJ_10775_공항
 *
 *	[풀이]
 *	1. g번째 비행기는 1번부터 g번 까지 도킹할수있다.
 *	2. g번째 부터 -1번부터 도킹을 시도한다.		 
 *	3. 유니온 파인드를 사용해서 도킹이 0번째로 간다면 더이상 운영할수 없다는 의미로 종료
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] parent;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		parent = new int[n+1];
		
		for(int i =0; i<n+1; i++) parent[i]=i;
		
		int answer = 0;
		for(int i =0; i<p; i++) {
			int airplane = Integer.parseInt(br.readLine());
			int door = findParent(airplane);
			if(door>0) {
				answer++;
				union(door,door-1);
			}else {
				break;
			}
		}
		System.out.println(answer);
	}
	
	public static void union(int x, int y) {
		x=findParent(x);
		y=findParent(y);
		
		if(x!=y) parent[x]=y;
	}
	
	public static int findParent(int x) {
		if(x==parent[x]) return x;
		return parent[x] = findParent(parent[x]);
	}
}

