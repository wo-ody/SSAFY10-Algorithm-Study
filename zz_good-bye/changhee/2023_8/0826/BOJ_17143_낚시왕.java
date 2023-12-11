/*
 *  08.26 김창희
 *  BOJ_17143_낚시왕
 *
 *  [풀이]
 *  1.해시맵으로 상어의 정보를 저장
 *  2.c만큼 반복하며 상어의 방향과 속도를 가져와 이동한다.
 *  3. 모든 상어가 이동 완료후 해시맵을 순회하며 한칸에 한마리의 상어만 남게 한다
 *  4. 추후 거리계산을 반복문이 아닌 수학적으로 개선 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0}, dy = {0, 0, 1, -1};
    static int[][] map;
    static HashMap<Integer, Node> shark = new HashMap<>();
    static int r, c, m, sharkNumber = 1, answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[r][c];

        sharkNumber = 1;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            map[x][y] = sharkNumber;
            shark.put(sharkNumber++, new Node(x, y, s, d, z));
        }
        play();
        System.out.println(answer);

    }

    public static void play() {
        for (int i = 0; i < c; i++) {
            hunt(i);
            moveShark();
        }
    }

    public static void hunt(int hunter) {
        for (int i = 0; i < r; i++) {
            if (map[i][hunter] > 0) {
                answer += shark.get(map[i][hunter]).z;
                shark.remove(map[i][hunter]);
                map[i][hunter] = 0;
                break;
            }
        }
    }

    public static void moveShark() {
        for (int key : shark.keySet()) {
            Node node = shark.get(key);

            int nx = node.x;
            int ny = node.y;
            for (int j = 0; j < node.s; j++) {
                nx += dx[node.d];
                ny += dy[node.d];

                if (node.d == 0 && nx <= 0) {
                    if (nx < 0) nx = 1;
                    node.d = 1;
                } else if (node.d == 1 && nx >= r - 1) {
                    if (nx >= r) nx = r - 2;
                    node.d = 0;
                } else if (node.d == 3 && ny <= 0) {
                    if (ny < 0) ny = 1;
                    node.d = 2;
                } else if (node.d == 2 && ny >= c - 1) {
                    if (ny >= c) ny = c - 2;
                    node.d = 3;
                }
            }

            map[node.x][node.y] = 0;
            node.x = nx;
            node.y = ny;
        }

        List<Integer> removeList = new ArrayList<>();
        for(int key : shark.keySet()){
            Node node = shark.get(key);
            if (map[node.x][node.y] == 0) {
                map[node.x][node.y] = key;
            } else {
                Node comp = shark.get(map[node.x][node.y]);
                if (node.z > comp.z) {
                    removeList.add(map[node.x][node.y]);
                    map[node.x][node.y] = key;
                } else {
                    removeList.add(key);
                }
            }
        }

        for(int key :removeList) shark.remove(key);
    }

    static class Node {
        int x, y, s, d, z;

        public Node(int x, int y, int s, int d, int z) {
            this.x = x;
            this.y = y;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
