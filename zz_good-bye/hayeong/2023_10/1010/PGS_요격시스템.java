import java.util.Arrays;

public class PGS_요격시스템 {

    public static int solution(int[][] targets) {
        int ans = 0;
        // 끝을 오름차순으로 정렬
        Arrays.sort(targets, (t1, t2) -> t1[1] - t2[1]);
        
        
        int end = targets[0][1];
        ans++; // 첫번쨰로 만들어지는 요격 시스템
        
        for(int[] tar : targets){
            if(tar[0]>=end){ // 현재 끝보다 시작점이 더 뒤에 있을떼 요격 시스템 추가
                end = tar[1]; // 끝지점을 업데이트
                ans++; // 요격 시스템 추가
            }
        }
        return ans;
    }
}
