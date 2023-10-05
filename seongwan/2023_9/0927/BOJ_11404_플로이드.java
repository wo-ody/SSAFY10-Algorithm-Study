import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
static StringTokenizer st;
static StringBuilder sb = new StringBuilder();
static int n,m;
static int[][] mat;
static int INF=10000000;


	public static void main(String[] args)throws Exception {
		n=Integer.parseInt(br.readLine());
		m=Integer.parseInt(br.readLine());
		
		mat=new int[n+1][n+1];//0은 더미
		for (int i = 0; i < m; i++) {
			st= new StringTokenizer(br.readLine());
			int from= Integer.parseInt(st.nextToken());
			int to= Integer.parseInt(st.nextToken());
			int w= Integer.parseInt(st.nextToken());
			if(mat[from][to]==0)
			   mat[from][to]=w;
			else {
				mat[from][to]=Math.min(mat[from][to], w);
			}//시작 도시와 도착 도시를 연결하는 노선은 하나가 아닐 수 있으므로 간선 중 최소로 설정
			
		}//인접행렬 입력
		
	floyd();
System.out.println(sb);
}
	static void floyd() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i!=j&&mat[i][j]==0)
					mat[i][j]=INF;
					}
		}//자기 자신으로 오는 거 제외하고 다른 도시로의 길이 없으면 가중치 INF로 처리
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <=n; j++) {
			       mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);;
			    }
			}
			
		}//플로이드-워셜
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i!=j&&mat[i][j]==INF)
				   sb.append(0+" ");//갈 수 없는 곳은 0으로 표시
					else sb.append(mat[i][j]+" ");
			}
			sb.append("\n");
		}//출력
	}
}
