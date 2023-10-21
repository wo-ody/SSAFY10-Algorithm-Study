import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_4386_별자리만들기 {
    static int N;
    static PriorityQueue<Edge> pq;
    static Point[] point;
    static int parent[];    //서로소

    static class Edge {
        int v1;
        int v2;
        double c;
    
        Edge(int v1, int v2, double c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }
    }

    static class Point {
        int num;
        double x;
        double y;
    
        Point(int num, double x, double y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }
    public static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
	}

    static void makeSet(){
        for(int i=1; i<=N; i++){
            parent[i] = i;
        }
    }
    static int find(int x){
        if(x == parent[x]) return x;
        else return parent[x] = find(parent[x]);
    }
    static boolean union(int x, int y){
        int px = find(x);
        int py = find(y);

        if(px == py) return false;
        if(px < py) parent[py] = px;
        else parent[px] = py;
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());

        pq = new PriorityQueue<>((e1, e2) -> (int)(e1.c - e2.c));
        point = new Point[N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());

            point[i] = new Point(i, x, y);
        }

        //간선 정보 추가하기
        for(int i=1; i<=N; i++){
            for(int j=i+1; j<=N; j++){
                double c = distance(point[i], point[j]);
                pq.add(new Edge(point[i].num, point[j].num, c));
            }
        }

        //서로소 초기화
        parent = new int[N+1];
        makeSet();

        //최소 찾기
        double cnt = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(union(e.v1, e.v2)) cnt += e.c;
        }

        System.out.printf("%.2f\n",cnt);
    
    }
}
