package Algorithm_2023.src.month11.day06;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_25757_임스와함께하는미니게임 {

    static int N, maxPlayer;
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        switch (st.nextToken().charAt(0)) {
            case 'Y' :
                maxPlayer = 2;
                break;
            case 'F' :
                maxPlayer = 3;
                break;
            case 'O' :
                maxPlayer = 4;
                break;
        }
        // 윷놀이 Y
        // 같은 그림 찾기 F
        // 원카드 O
        // 각각 2, 3, 4 명이서 플레이
        // 한 번 같이 플레이한 사람과는 다시 플레이하지 않습니다.
        int playerCnt = 1;
        int playCnt = 0;
        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            if (set.contains(name)) continue;
            else {
                playerCnt++;
                set.add(name);
                if(playerCnt == maxPlayer) {
                    playCnt++;
                    playerCnt = 1;
                }
            }
        }

        System.out.println(playCnt);

    }
}
