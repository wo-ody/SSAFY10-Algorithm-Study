import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간 복잡도 개선한 코드
public class Main {
	static int N, ans;
    static int[][] inning;
    static int[] src = { 0, 1, 2, 3, 4, 5, 6, 7, 8 };
    static int[] tgt = new int[9];
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        // 자료구조 초기화
        inning = new int[N][9];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                inning[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //1번 선수는 무조건 4번째 타자
        tgt[3] = src[0];
        
        // 풀이
        perm(1, 1<<3); // index, mask(4번째는 차있다는 뜻)
        
        System.out.println(ans);
    }

    static void perm(int srcIdx, int mask) {
        // 기저조건
        if( srcIdx == 9 ) {
            // complete code
            game();
            return;
        }
        
        // 모든 0 - 8 에 대해서 이전에 사용하지 않은 것 제외하고 고려
        for (int i = 0; i < 9; i++) { // src[0] 는 tgt[3](4번자리) 에 고정
            
            if( (mask & 1 << i) != 0 ) continue;
            
            tgt[i] = src[srcIdx];
            perm(srcIdx + 1, mask | 1 << i);
        }
    }
    
    static void game() {
        // 게임 초기화
        int score = 0;  // 점수
        int player = 0; // 선수 순번 (index)
        
        // 이닝 반복 (N만큼)
        for (int i = 0; i < N; i++) {
            
            int base = 0; // 주자 - bitmask   0000 (주자 X) 0001 (1루에만 주자) 1101(1점 + 1,3루) 111111
            int out = 0;
            // 매 이닝별로 타자를 순서대로 세워서 안타, 아웃을 주어진 입력대로 계산
            // 이전 마지막으로 아웃된 다음 타자 순번부터 시작 ( player 가 계속 갱신 )
            for (int j = player; j < 9; j++) {
                
                int num = inning[i][ tgt[j]  ]; // i 번째 이닝에서 j 번째 선수 <= tgt[j]
                
                if( num == 0 ) { // 아웃
                    out++;
                    if( out == 3 ) {
                        player = j + 1; // 아웃된 마지막타자 다음 타자로 변경
                        if( player == 9 ) player = 0;
                        break; // 현재 for 종료 => 다음 이닝  (바깥 for 다음 진행 )
                    }
                }else { // 안타, 홈런
                    // 0011 -> 0110
                    // 기존 base 를 왼쪽으로 num 만큼 밀고 오른쪽에 num 주루 표시
                    base = base << num;
                    base = base | 1 << num - 1; //
                    
                    // 점수 계산
                    score += score(base);
                    
                    // 3루까지를 제외한 점수에 해당하는 주로 표시 초기화
                    base = base & ( ~(1 << 3) );
                    base = base & ( ~(1 << 4) );
                    base = base & ( ~(1 << 5) );
                    base = base & ( ~(1 << 6) );
                }
                
                if( j == 8 ) j = -1; // 맨 앞으로 보정되도록
            }
        }
            
        ans = Math.max(ans, score);
        
    }
    
    static int score(int base) {
        int sum = 0;
        sum += ( base & 1 << 3 ) != 0 ? 1 : 0; // 0001    => 0001000
        sum += ( base & 1 << 4 ) != 0 ? 1 : 0; // 00001   => 0010000
        sum += ( base & 1 << 5 ) != 0 ? 1 : 0; // 0001    => 0100000
        sum += ( base & 1 << 6 ) != 0 ? 1 : 0; // 0001    => 1000000
        return sum;
    }
}
