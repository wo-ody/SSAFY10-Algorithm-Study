
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_20055_컨베이어벨트위의로봇 {

    static int N, K, cnt, level;
    static LinkedList<Node> belt;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        cnt = 0;
        level = 0;
        belt = new LinkedList<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N * 2; i++) {
            int value = Integer.parseInt(st.nextToken());
            if( value == 0 ) {
            	cnt++; // 이미 내구도가 0인 경우 cnt 해주기
            	belt.add(new Node(value, true)) ; // 내구도, zeroCheck
            } else {
            	belt.add(new Node(value, false)) ; // 내구도
            }
        }
        
        // 0 개수가 K개 미만이면 계속 진행
        while(cnt < K) {
        	level++; // 레벨 1부터 시작
        	
            // 1. 벨트 회전
            belt.addFirst( belt.removeLast() );
            // 회전 후 로봇의 위치가 N-1인 경우 내려준다.
            if(belt.get(N-1).existRobot) belt.get(N-1).existRobot = false;
            
            // 2. 로봇 이동 (가장 먼저 들어온 로봇부터 이동)
            for (int i = N-2; i >= 0; i--) {
            	// 로봇이 존재하는가
            	if(belt.get(i).existRobot) {
            		int next = i + 1;
            		// 다음 칸에 로봇이 없어야되고, 내구도가 0이 아니어야 한다.
            		if( !belt.get(next).existRobot && !belt.get(next).zeroCheck ) {
            			// 로봇 위치 체인지
            			belt.get(i).existRobot = false;
            			belt.get(next).existRobot = true;
            			// 내구도가 줄어듭니다
            			belt.get(next).value--;
            			
            			// 이동한 로봇의 위치가 N-1인 경우 내려준다.
            			if(next == N-1) belt.get(next).existRobot = false;
            			
            			// 이전에 체크한적 없는 내구도가 0이되면 zeroCheck를 true로 변경해주고 cnt++ 해준다.
            			if( !belt.get(next).zeroCheck && belt.get(next).value == 0 ) {
            				cnt++;
            				belt.get(next).zeroCheck = true;
            			}
            		}
            	}
            	
            }
            
            // 3. 새로운 로봇 올리기
            // 첫번째 칸에 로봇이 없어야되고, 내구도가 0이 아니어야 한다.
            if( !belt.get(0).existRobot && !belt.get(0).zeroCheck ) {
            	belt.get(0).existRobot = true;
                belt.get(0).value--;
                
                if( !belt.get(0).zeroCheck && belt.get(0).value == 0 ) {
    				cnt++;
    				belt.get(0).zeroCheck = true;
    			}
            }

        }
        
        // 정답 출력
        System.out.println(level);
        
    }
    
    static class Node {
        int value;
        boolean existRobot;
        boolean zeroCheck;

        public Node(int value, boolean zeroCheck) {
            this.value = value;
            this.zeroCheck = zeroCheck;
        }
    }

}