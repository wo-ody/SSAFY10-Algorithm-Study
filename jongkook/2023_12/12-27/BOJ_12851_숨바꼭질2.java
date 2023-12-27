package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_12851_숨바꼭질2 {
    static int range = 100_000, subin, brother, way, min = Integer.MAX_VALUE, value;
    static int[] map = new int[range+1], method = {-1,1,2};
    static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        subin = Integer.parseInt(st.nextToken());
        brother = Integer.parseInt(st.nextToken());

        if(subin >= brother){
            System.out.println(subin-brother);
            System.out.println(1);
            return;
        }

        hideAndSeek();
        System.out.println(min);
        System.out.println(way);

    }
    static void hideAndSeek(){
        queue.add(subin);
        map[subin] = 1;

        while (!queue.isEmpty()) {
            int current = queue.pop();

            if(min < map[current]) return;

            for(int i = 0; i < 3; i++){
                if(i == 2) value = current * method[i];
                else value = current + method[i];

                if(!rangeCheck(value)) continue;

                if(value == brother) {
                    min = map[current];
                    way++;
                }

                if(map[value] == 0 || map[value] == map[current] + 1){
                    queue.add(value);
                    map[value] = map[current] + 1;
                }
            }

        }
    }
    static boolean rangeCheck(int value){
        return 1 <= value  && value <= range;
    }
}
