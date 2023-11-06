import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int length = sizes.length;
        int max = 0;
        int[] min = new int[length]; //각 w,h 중 작은 수 

        for(int i=0; i<length; i++){
            min[i] = Math.min(sizes[i][0], sizes[i][1]);
            max = Math.max(max, sizes[i][0]);
            max = Math.max(max, sizes[i][1]); //가장 큰 수 구하기
        }

        Arrays.sort(min);

        answer = min[length-1] * max;

        return answer;
    }
}
