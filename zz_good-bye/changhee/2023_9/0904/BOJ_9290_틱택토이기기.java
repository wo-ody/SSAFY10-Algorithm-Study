import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dx= {0,1,1,1,0}, dy={1,1,0,-1,-1};
    static char[][] map;
    static int n = 3;
    static char tic;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int t= Integer.parseInt(br.readLine());
        for(int tc=1; tc<=t; tc++){
            map=new char[n][n];
            for(int i =0; i<n; i++) map[i] = br.readLine().toCharArray();
            tic = br.readLine().charAt(0);

            boolean flag = false;
            for(int i =0; i<n; i++){
                for(int j =0; j<n; j++){
                    if(map[i][j] == '-'){
                        map[i][j] = tic;
                         if(chk()){
                             flag=true;
                             break;
                         }
                         map[i][j] = '-';
                    }
                    if(flag) break;
                }
                if(flag) break;
            }

            answer.append("Case").append(" ").append(tc).append(":\n");
            for(int i =0; i<n; i++){
                for(int j =0; j<n;j++){
                    answer.append(map[i][j]);
                }
                answer.append("\n");
            }

        }
        System.out.println(answer);

    }
    public static boolean chk(){
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]!=tic) continue;

                for(int x= 0; x<5; x++){
                    int nx=i;
                    int ny=j;
                    int count  =1;
                    while(true){
                        nx+=dx[x];
                        ny+=dy[x];
                        if(nx<0||ny<0||nx>=n||ny>=n) break;
                        if(map[nx][ny] ==  tic && ++count == 3)return true;
                    }
                }
            }
        }
        return false;
    }
}
