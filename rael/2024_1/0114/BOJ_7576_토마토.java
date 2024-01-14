import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {	

	    static int n, m;
	    static int[][] map; // 토마토친구들 위치를 담는 배열 
	    static Queue<Position> que = new LinkedList<Position>(); // bfs돌릴 queue
	    static int[] xx={0,0,1,-1}; // 상하좌우순- x좌표 움직임을 담는 배열 
	    static int[] yy={1,-1,0,0}; // 상하좌우순- y좌표 움직임을 담는 배열 
	    static int finalCount; // 토마토 익히는데 걸린 총 소요일수 
	    static int countInitialZero; // 처음 map을 받았을 때  "0"이었던  친구들의 수
	    static int changeZeroToOne; // "0"이었다 "1"로 바뀐 친구들의 수

	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st;

	        st = new StringTokenizer(br.readLine());
	        m = Integer.parseInt(st.nextToken());
	        n = Integer.parseInt(st.nextToken());

	        map = new int[n][m];
	        
	        for(int i=0; i<n; i++){
	            st= new StringTokenizer(br.readLine());
	            for(int j=0; j<m; j++){
	                map[i][j]= Integer.parseInt(st.nextToken());
	                if(map[i][j] == 1){
                    
                    // map을 돌면서 해당 인덱스 값이 1(익은토마토)인 경우
                    // 해당위치에서 네 방향으로 돌리기 위해 
                    // queue에 넣는다
	                    que.add(new Position(i,j,0));
	                } else if(map[i][j] == 0) countInitialZero += 1; 
                    // // map을 돌면서 해당 인덱스 값이 0(안익은토마토)인 경우
                    // 마지막에 queue에 총 add된 수 (0->1로 바꾼 토마토 수)와
                    // 처음 0이었던 토마토 수를 비교해 익힐 수 없는 토마토가 있는지
                    // 비교하기위해 (익힐 수 없는 토마토가 있으면 -1리턴해야함)
                    // countInitialZero값을 채운다 
	            }
	        } 
	        bfs();
            
	        if (countInitialZero == 0) System.out.print(0);
            // 원래부터 토마토가 다 익어있었을 경우 0출력
	        else if(countInitialZero == changeZeroToOne) {
	        // 원래 안익어있던 토마토 == 익힌토마토일 경우 
            // finalCount출력
	        	System.out.print(finalCount);
	        }
	        else { 
	        	System.out.print(-1);
                // 원래 안익어있던 토마토 != 익힌토마토일 경우
                // 익힐 수 없는 토마토가 있는 것! -1 리턴
	        } 
	    }
	    
	     public static void bfs(){
	         while(!que.isEmpty()){
	             Position p=que.poll();
	             
	             for (int i=0;i<4;i++){
	                 if(p.x+xx[i]>=0 && p.x+xx[i]<n && p.y+yy[i] >=0 && p.y+yy[i]<m){
                     // 네 방향으로 움직이되,
                     // 움직여진 인덱스의 값이 배열 인덱스 범위 안 이면서
	                     if(map[p.x+xx[i]][p.y+yy[i]]==0){
                         	// 해당 위치의 토마토가 "0" 안익은 상태라면
	                         que.add(new Position(p.x+xx[i],p.y+yy[i],p.count+1));
                             // 해당 위치를 queue에 넣음 
	                         map[p.x+xx[i]][p.y+yy[i]] = 1;
                             // 그리고 1로 변경 
	                         finalCount = p.count+1;
	                         changeZeroToOne += 1;
                             // count 값 증가시키고
                             // 1로바꾼 토마토 수도 증가
	                     }	                     
	                 }
	             }
	         }
	     }   
	    public static class Position{
	    int x;
	    int y;
	    int count;
	    
	    public Position(int x, int y, int count){
	        this.x=x;
	        this.y=y;
	        this.count=count;
	    }
	}
	

}
