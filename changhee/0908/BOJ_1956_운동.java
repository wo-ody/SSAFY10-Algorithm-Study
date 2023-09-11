import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st=new StringTokenizer(br.readLine());
        int n =Integer.parseInt(st.nextToken());
        int m =Integer.parseInt(st.nextToken());
        int INF=Integer.MAX_VALUE;

        int[][] dist =new int[n+1][n+1];
        for(int i =1; i<n+1; i++) Arrays.fill(dist[i],Integer.MAX_VALUE);

        for(int i =0; i<m; i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            dist[x][y]=cost;
        }

        for(int k=1; k<n+1; k++){
            for(int i=1; i<n+1; i++){
                for(int j=1; j<n+1; j++){
                    if(i==j || dist[i][k]==INF || dist[k][j] == INF) continue;
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int answer = INF;
        for(int i =1; i<n+1; i++){
            for(int j=1; j<n+1; j++){
                if(i==j||dist[i][j]==INF||dist[j][i]==INF) continue;
                answer=Math.min(answer,dist[i][j]+dist[j][i]);
            }
        }

        System.out.println(answer==INF?-1:answer);
    }
}
