import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {
    static int N, idx;
    static Edge[] edgeList;

    static Edge[] pointList;

    static int[] target = new int[2];

    static int[] parents;

    // Edge 재사용
    //      좌표 입력 받을 때, cost = 0으로 받아 사용
    //      크루스칼 쓸 때, 입력받은 별의 index(정접 번호)를 from, to로 사용
    static class Edge implements Comparable<Edge> {
        double from, to, cost;

        Edge(double from, double to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }


        public int compareTo(Edge o) {
            if (this.cost - o.cost > 0) return 1;
            else return -1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());

        pointList = new Edge[N]; // x좌표, y좌표, cost = 0;
        edgeList = new Edge[N * (N - 1) / 2]; // 두 별의 인덱스, cost

        // 좌표입력
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double from = Double.parseDouble(st.nextToken());
            double to = Double.parseDouble(st.nextToken());
            pointList[i] = new Edge(from, to, 0); // 좌표 입력받을때 cost=0으로 하고 Edge자료형을 씀
        }
        // 조합으로 가중치 다 구해서 edList에 넣기
        comb(0, 0);

        // 크루스칼로 MST 구하기
        Arrays.sort(edgeList);
        make();
        double result = 0;
        int cnt = 0;
        for (Edge e : edgeList) {
            if (union((int) e.from, (int) e.to)) { // 두 정점에 대해
                result += e.cost;
                if (++cnt == N - 1) break;

            }
        }
        System.out.println(Math.round(result * 100) / 100.0); // 소수점 아래 둘쨰 자리까지

    }

    static void comb(int srcIdx, int tgtIdx) {
        if (tgtIdx == 2) {
            // complete code
            double x1 = pointList[target[0]].from;
            double y1 = pointList[target[0]].to;
            double x2 = pointList[target[1]].from;
            double y2 = pointList[target[1]].to;
            double cost = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
            edgeList[idx++] = new Edge(target[0], target[1], cost); // pointIdx, pointIdx, cost
            return;
        }
        if (srcIdx == N) return;

        target[tgtIdx] = srcIdx;
        comb(srcIdx + 1, tgtIdx + 1);
        comb(srcIdx + 1, tgtIdx);
    }

    static void make() {
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    static int find(int a) {
        if (parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return false;
        parents[rootB] = rootA;
        return true;
    }
}
