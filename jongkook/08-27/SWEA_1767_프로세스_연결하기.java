
import java.util.*;
import java.io.*;
public class SWEA_1767_프로세스_연결하기 {
    static int[][] map;
    static int line;
    static ArrayList<Core> coil;
    static int min, max;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws  IOException{
        System.setIn(new FileInputStream("src//input//SWEA_1767_input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++){
            line = Integer.parseInt(br.readLine());
            map = new int[line][line];
            coil = new ArrayList<>();

            for(int i = 0; i < line; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < line; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1){
                        if(i == 0 || i == line -1 || j == 0 || j == line - 1) continue;
                        coil.add(new Core(i, j));
                    }
                }
            }
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            connect(0, 0, 0);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb);
    }
    static void connect(int idx, int coreCount, int lineCount){
        if(idx == coil.size()){
            if(max < coreCount){
                max = coreCount;
                min = lineCount;
            }
            else if(max == coreCount) min = Math.min(min, lineCount);

            return;
        }

       int x = coil.get(idx).x;
       int y = coil.get(idx).y;

       for(int dir = 0; dir < 4; dir++){
           int count = 0;
           int nx = x;
           int ny = y;
           int originX = x;
           int originY = y;
           while(true){
//               System.out.println("asd");
               nx += dx[dir];
               ny += dy[dir];
               if( nx < 0 || ny < 0 || nx >= line || ny >= line) break;
               if(map[ny][nx] == 1) {
                   count = 0;
                   break;
               }
               count++;
          }

           for(int j = 0; j < count; j++){
               originX += dx[dir];
               originY += dy[dir];
               map[originY][originX] = 1;
           }
           if(count == 0) connect(idx+1, coreCount, lineCount);
           else {
               connect(idx+1, 1 + coreCount, lineCount + count);
               originX = x;
               originY = y;
               for(int j = 0; j < count; j++){
                   originX += dx[dir];
                   originY += dy[dir];
                   map[originY][originX] = 0;
               }
           }
       }
    }

    static class Core{
        int y, x;

        public Core(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
