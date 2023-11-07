package Algorithm_2023.src.month11.day07;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_21609_상어중학교 {

    static int N, M, score;
    static int[][] map;
    static int[][] groupCheck;

    //                  상, 하, 좌, 우
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static int downY = 1;
    static int downX = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 와... 진짜 끔찍한 구현 문제인것같다..

        // N X N

        // 공백 : -2
        // 검은색 블록 : -1
        // 무지개 블록 : 0
        // 일반 블록 : 1 ~ M

        // |r1 - r2| + |c1 - c2| = 1을 만족하는 두 칸 (r1, c1)과 (r2, c2)를 인접한 칸이라고 한다.
        // -> 4방 탐색

        // @블록 그룹의 조건
        // 1. 일반블록(1~M)이 반드시 1개 이상이고 모두 같은 번호
        // 2. 검은색(-1)은 포함되면 안됨
        // 3. 무지개(0)는 상관 없음
        // 4. 총 블록이 2개 이상이어야 가능
        // 5. 기준블록이라는 것이 있음 : (1. 행이 가장 작은, 2. 열이 가장 작은)
        // ==> 0,0부터 차례대로 탐색했을 때 들어갈 때의 블럭을 기준 블럭으로 정하고 들어가면 됨

        // @@오토 플레이
        // 1. 블록그룹 제거 (제거 조건)
        // ->   1) 크기가 가장 큰 블록 -> 전체 개수 저장
        //      2) 무지개가 가장 많은 블록 그룹 -> 무지개 개수도 세야됨
        //      3) 기준블록의 행이 가장 큰 것, 열이 가장 큰 것 -> 가장 먼저 찾은 블록그룹
        // 2. 제거한 블록의 개수^2 점 획득
        // 3. 중력 ( 검은색을 제외하고 다 아래로 이동 )
        // 4. 배열 전체 90도 반시계 회전
        // 5. 중력 1번 더

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cntTime = 0;
        while(true) {
            groupCheck = new int[N][N];
            // 1. 블록그룹 제거
            // 제거할 그룹 찾기
            int groupNum = 0;
            Group maxGroup = new Group(0, 0, 0, false, 0, 0); // { 0, 0 } 전체개수, 무재개 개수
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 이미 그룹을 체크했거나, 무지개블럭이면?(기준블럭이 될수 없기 때문에)
                    if (groupCheck[i][j] != 0 || map[i][j] == 0) continue;
                    Group curGroup = findGroup(i, j, ++groupNum);
                    System.out.println("("+i+", "+j+")");
                    System.out.println("\n maxGroup : " + maxGroup.toString() + "\n");
                    System.out.println("\n curGroup : " + curGroup.toString() + "\n");
                    // 그룹일 때에만 maxGroup 업데이트
                    if (curGroup.isGroup) {
                        if (maxGroup.cntAll < curGroup.cntAll) {
                            maxGroup = curGroup;
                        } else if (maxGroup.cntAll == curGroup.cntAll) {
                            if (maxGroup.cntRainbow < curGroup.cntRainbow) {
                                maxGroup = curGroup;
                            }
                        }
                    }
                }
            }
            debug("\n" + maxGroup.toString() + "\n");
            // maxGroup을 맵에서 제거 (bfs)
            deleteGroup(maxGroup.y, maxGroup.x, maxGroup.groupNum);


            debug("그룹블럭 제거 후");
            System.out.println(maxGroup.cntAll);
            System.out.println(maxGroup.cntRainbow);

            // 2. 제거한 블록의 개수^2 점 획득
            score += maxGroup.cntAll * maxGroup.cntAll;

            // 3. 중력 ( 검은색을 제외하고 다 아래로 이동 )
            for (int i = N - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    if (map[i][j] < 0) continue;
                    fall(i, j);
                }
            }
            
            debug("중력 작용 후");

            // 4. 배열 전체 90도 반시계 회전
            int[][] mapCopy = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mapCopy[i][j] = map[j][N-1-i];
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = mapCopy[i][j];
                }
            }

            debug("회전 후");

            // 5. 중력 1번 더
            for (int i = N - 1; i >= 0; i--) {
                for (int j = N - 1; j >= 0; j--) {
                    if (map[i][j] < 0) continue;
                    fall(i, j);
                }
            }

            debug("중력 한번 더");

            // 6. 갱신된 그룹이 없다면?
            debug("\n" + maxGroup.toString() + "\n");
            if (!maxGroup.isGroup) break;



            if(cntTime++ > 10) break;
        }
        System.out.println(score);

    }

    static void deleteGroup(int y, int x, int deleteNum) {
        boolean[][] visit = new boolean[N][N];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{y, x});
        map[y][x] = -2;
        visit[y][x] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            map[cur[0]][cur[1]] = -2;
            visit[cur[0]][cur[1]] = true;

            for (int d = 0; d < 4; d++) {
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                // 범위벗어나거나면 continue
                if (isOutRange(ny, nx) || visit[ny][nx]) continue;
                // 같은 번호이거나, 무지개색일 때에만 큐에 넣는다.
                if ( groupCheck[ny][nx] == deleteNum || groupCheck[ny][nx] == -1) {
                    queue.offer(new int[]{ny, nx});
                }
            }
        }
    }

    static void debug(String str) {
        System.out.println("───── " + str + " ─────");
        System.out.println("score : " + score);
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }

    static void fall(int y, int x) {
        int temp = map[y][x];
        map[y][x] = -2;
        int ny = y;
        while(true) {
            ny++;
            if( ny >= N || map[ny][x] != -2 ) break;
        }
        map[ny-1][x] = temp;
    }

    static Group findGroup(int y, int x, int groupNum) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean isGroup = false; // 그룹이 가능한지
        int cnt = 0; // 블록 개수 세기
        int cntRainbow = map[y][x] == 0 ? 1 : 0; // 무지개 블럭
        int color = map[y][x];
        queue.offer(new int[]{y, x});

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int d = 0; d < 4; d++) {
                int ny = cur[0] + dy[d];
                int nx = cur[1] + dx[d];
                // 범위벗어나거나,
                if (isOutRange(ny, nx)) continue;
                // 검은 블록이거나, 비었거나 이미 체크했다면 continue, 0이상 다른 컬러여도
                if ( map[ny][nx] < 0 || groupCheck[ny][nx] > 0
                    || (map[ny][nx] != color && map[ny][nx] > 0) )  continue;
                if (map[ny][nx] == 0) groupCheck[ny][nx] = -1; // 무지개는 -1으로 표기
                else groupCheck[ny][nx] = groupNum;
                cnt++;
                if (map[ny][nx] == 0) cntRainbow++;
                queue.offer(new int[]{ny, nx});
            }
        }
        if (cnt >= 2) isGroup = true;
        return new Group(y, x, groupNum, isGroup, cnt, cntRainbow);
    }

    static boolean isOutRange(int y, int x) {
        return y >= N || y < 0 || x >= N || x < 0;
    }

    static class Group {
        int y, x, groupNum;
        boolean isGroup;
        int cntAll, cntRainbow;
        public Group(int y, int x, int groupNum, boolean isGroup, int cntAll, int cntRainbow) {
            this.y = y;
            this.x = x;
            this.groupNum = groupNum;
            this.isGroup = isGroup;
            this.cntAll = cntAll;
            this.cntRainbow = cntRainbow;
        }

        @Override
        public String toString() {
            return "Group{" +
                    "y=" + y +
                    ", x=" + x +
                    ", groupNum=" + groupNum +
                    ", isGroup=" + isGroup +
                    ", cntAll=" + cntAll +
                    ", cntRainbow=" + cntRainbow +
                    '}';
        }
    }

}




















