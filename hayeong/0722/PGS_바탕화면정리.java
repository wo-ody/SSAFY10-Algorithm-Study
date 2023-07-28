public class 바탕화면정리 {
    public int[] solution(String[] wallpaper) {
        int[] answer;
        char[][] board = new char[wallpaper.length][];
        int n = wallpaper.length;
        int m = wallpaper[0].length();
        for(int i = 0; i<wallpaper.length; i++){
            board[i] = wallpaper[i].toCharArray();
        }

        int lux = Integer.MAX_VALUE;
        int luy = Integer.MAX_VALUE;
        int rdx = Integer.MIN_VALUE;
        int rdy = Integer.MIN_VALUE;

        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(board[i][j] == '#'){
                    lux = Math.min(lux, i);
                    luy = Math.min(luy, j);
                    rdx = Math.max(rdx, i);
                    rdy = Math.max(rdy, j);
                }
            }
        }
        answer = new int[]{lux, luy, rdx+1, rdy+1};

        return answer;
    }
}
