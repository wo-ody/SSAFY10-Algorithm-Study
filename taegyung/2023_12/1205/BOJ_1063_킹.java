package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BOJ_1063_킹 {
    static int king_x,king_y,stone_x,stone_y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 돌이 하나 얘나 킹이 나가면 이 움직이는건 넘어가는걸로

        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String stone = st.nextToken();

        king_x = king.toCharArray()[1]-'0'-1;
        king_y = king.toCharArray()[0]-'A';
        stone_x = stone.toCharArray()[1]-'0'-1;
        stone_y = stone.toCharArray()[0]-'A';
        Map<String,int[]> commands = new HashMap<>();
        commands.put("L",new int[]{0,-1});
        commands.put("LB",new int[]{-1,-1});
        commands.put("LT",new int[]{1,-1});
        commands.put("R",new int[]{0,1});
        commands.put("RB",new int[]{-1,1});
        commands.put("RT",new int[]{1,1});
        commands.put("B",new int[]{-1,0});
        commands.put("T",new int[]{1,0});


        int move_cnt = Integer.parseInt(st.nextToken());


        for(int i = 0 ; i < move_cnt; i ++){
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            int king_nx = king_x +commands.get(command)[0];
            int king_ny = king_y +commands.get(command)[1];

            int stone_nx = stone_x +commands.get(command)[0];
            int stone_ny = stone_y +commands.get(command)[1];

            if (king_nx < 0 || king_nx > 7|| king_ny < 0 ||king_ny>7 || (king_nx == stone_x && king_ny ==stone_y && (stone_nx <0 ||stone_nx>7|| stone_ny<0||stone_ny >7))){


                continue;
            }
            if (king_nx == stone_x && king_ny ==stone_y ){
                stone_x = stone_nx;
                stone_y = stone_ny;
            }

            king_x = king_nx;
            king_y = king_ny;

        }

        System.out.println((char)(king_y+65)+""+(king_x+1));
        System.out.println((char)(stone_y+65)+""+(stone_x+1));

    }
}
