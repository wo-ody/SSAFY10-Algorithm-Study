class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        
        int w= 0;int h =0;
        
        for(int i = 0;i<sizes.length;i++){
            int nw = Math.max(w,sizes[i][0]);
            int nh = Math.max(h,sizes[i][1]);
            
            int rw = Math.max(w,sizes[i][1]);
            int rh = Math.max(h,sizes[i][0]);
            
            if(rw*rh<nw*nh){
                w = rw;
                h = rh;
            }else{
                w = nw;
                h = nh;
            }
        }
        answer = w*h;
        return answer;
    }
}
