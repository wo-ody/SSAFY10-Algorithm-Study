import java.io.*;
import java.util.*;

public class Main {
	static int N,M,R,count=1;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();	//그래프 값 저장
	static int[] result;	//순번 저장 배열
	static boolean[] visited;	//방문 확인 배열
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //입력값 처리하는 BufferedReader
    	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //결과값 출력하는 BufferedWriter
    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //그래프 값 저장
    	N = Integer.parseInt(st.nextToken());
    	M = Integer.parseInt(st.nextToken());
    	R = Integer.parseInt(st.nextToken());
    	result = new int[N+1];
    	visited = new boolean[N+1];
    	for(int i=0;i<=N;i++)
    		graph.add(new ArrayList<>());
    	for(int i=0;i<M;i++) {
    		st = new StringTokenizer(br.readLine()," ");
    		int u = Integer.parseInt(st.nextToken());
    		int v = Integer.parseInt(st.nextToken());
    		graph.get(u).add(v);
    		graph.get(v).add(u);
    	}
    	bfs(R);		//너비 우선 탐색 수행
    	for(int i=1;i<=N;i++)	//순번 BufferedWriter 저장
    		bw.write(result[i] + "\n");
    	bw.flush();		//결과 출력
    	bw.close();
    	br.close();
    }
    //너비 우선 탐색하는 함수
    static void bfs(int start) {
    	Queue<Integer> queue = new LinkedList<Integer>();
    	result[start] = count++;	//순번 저장
    	visited[start] = true;	//방문 확인
    	queue.add(start);
    	while(!queue.isEmpty()) {
    		int point = queue.poll();
    		Collections.sort(graph.get(point),Collections.reverseOrder());	//내림차순 정렬
    		for(int next : graph.get(point)) {	//인접 정점 탐색
    			if(!visited[next]) {	//방문했는지 확인
    				visited[next] = true;	//방문 확인
    				result[next] = count++;	//순번 확인
    				queue.add(next);
    			}
    		}
    	}
    	return;
    }
}
