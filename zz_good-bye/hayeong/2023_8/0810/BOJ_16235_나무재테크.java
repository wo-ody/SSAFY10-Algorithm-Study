import java.io.*;
import java.util.*;

// N: 맵의 크기
// M: 나무의 개수
// K: K년이 지난 후
// A[r][c]: 추가되는 양분의 양
// x y z: 나무의 위치, 나이

class Tree implements Comparable<Tree> {
    int x, y, age;

    public Tree(int x, int y, int age) {
        super();
        this.x = x;
        this.y = y;
        this.age = age;
    }

    @Override
    public int compareTo(Tree o) {
        return this.age - o.age;
    }
}

public class 나무재테크_16235 {
    static int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    static int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] A = new int[N + 1][N + 1];
        int[][] soil = new int[N + 1][N + 1]; // 양분
        Deque<Tree> treeList = new ArrayDeque<>();

        // A[r][c] 입력, 토양 초기화: 5
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
                soil[i][j] = 5;
            }
        }

        // 나무 리스트에 추가
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int tree_age = Integer.parseInt(st.nextToken());
            treeList.add(new Tree(x, y, tree_age));
        }

        while (K > 0) {
            Queue<Tree> deadList = new LinkedList<>();

            // 봄
            for (int i = 0; i < treeList.size();i++) {
                Tree cur = treeList.poll();
                if (soil[cur.x][cur.y] >= cur.age) {
                    soil[cur.x][cur.y] -= cur.age;
                    cur.age++;
                    treeList.add(cur);
                } else {
                    deadList.add(cur);
                    i--;
                }
            }

            // 여름
            for (Tree t : deadList) {
                soil[t.x][t.y] += t.age / 2;
            }

            // 가을
            Queue<Tree> tempList = new LinkedList<>();
            for (Tree t : treeList) {
                if (t.age % 5 == 0) {
                    tempList.add(t);
                }
            }
            while (!tempList.isEmpty()) {
                Tree t = tempList.poll();

                for (int i = 0; i < 8; i++) {
                    int nx = t.x + dx[i];
                    int ny = t.y + dy[i];
                    if (nx >= 1 && nx <= N && ny >= 1 && ny <= N) {
                        treeList.addFirst(new Tree(nx, ny, 1));
                    }
                }
            }

            // 겨울
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    soil[i][j] += A[i][j];
                }
            }

            K--;
        }

        System.out.println(treeList.size());
    }
}
