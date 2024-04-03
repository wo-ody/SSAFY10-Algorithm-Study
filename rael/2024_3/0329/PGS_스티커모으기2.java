class Solution {
    public int solution(int[] sticker) {
        // 스티커 하나 가지치기
        if (sticker.length == 1) return sticker[0];
        
        // 첫(o), 막(x)
        // 첫(x), 막(o)
        // 둘 중 더 큰 값
        return Math.max(maxStickerValue(sticker, 0, sticker.length - 2),
                        maxStickerValue(sticker, 1, sticker.length - 1)); 
    }

    private int maxStickerValue(int[] sticker, int start, int end) {
        int n = end - start + 1;
        if(n == 0) return 0;
        if(n == 1) return sticker[start];
        
        int[] dp = new int[n];
        //첫번째 스티커로 초기화
        dp[0] = sticker[start];
        //두번째 스티커는 첫번째랑 비교해서 넣기
        dp[1] = Math.max(sticker[start], sticker[start+1]);
        
        //dp ㄱㄱ
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[start+i]);
        }
        
        return dp[n-1];
    }
}
