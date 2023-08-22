import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int T, K;
	static int[][] magnetics;
	static int[] arrows;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=null;
		T=Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			magnetics=new int[4][8];
			arrows=new int[4];
			K=Integer.parseInt(br.readLine());
			for (int i=0; i<4; i++) {
				st=new StringTokenizer(br.readLine());
				for (int j=0; j<8; j++) {
					magnetics[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			for (int i=0; i<K; i++) {
				st=new StringTokenizer(br.readLine());
				int num=Integer.parseInt(st.nextToken())-1;
				int dir=Integer.parseInt(st.nextToken());
				int[] results=new int[4];
				dfs(num, dir, results, new boolean[4]);
				for (int j=0; j<4; j++) {
					if (results[j]!=0) rotates(j, results[j]);
				}
			}
			int answer=0;
			int score=1;
			for (int i=0; i<4; i++) {
				if (magnetics[i][arrows[i]]==1) answer+=score;
				score*=2;
			}
            sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int num, int dir, int[] results, boolean[] visited) {
		results[num]=dir;
		visited[num]=true;
		//왼
		int left=num-1;
		if (left>=0 && !visited[left]) {
			int e1=(arrows[left]+2)%8;
			int e2=(arrows[num]+6)%8;
			if (magnetics[left][e1]!=magnetics[num][e2]) {
				dfs(left, -1*dir, results, visited);
			}
		}
		//오
		int right=num+1;
		if (right<4 && !visited[right]) {
			int e1=(arrows[right]+6)%8;
			int e2=(arrows[num]+2)%8;
			if (magnetics[right][e1]!=magnetics[num][e2]) {
				dfs(right, -1*dir, results, visited);
			}
		}
		
	}

	private static void rotates(int num, int dir) {	//arrow의 위치를 이동시켜줌
		if (dir==1) {
			arrows[num]=(arrows[num]+7)%8;
		}
		else if (dir==-1) {
			arrows[num]=(arrows[num]+1)%8;
		}
		
	}
}
