class Solution {
    int MOD = 20170805;
    Vector[][] v;       //이동 방향 결정
    
    class Vector {
        int row;
        int col;
        
        Vector(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    
    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        v = new Vector[m][n];
        
        //방향 초기화
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                v[i][j] = new Vector(0,0);
            }
        }
        //시작지점 방향 지정
        v[0][0] = new Vector(1,1);  //오른쪽 아래로 이동
        
        //맵 돌면서 방향 지정해주기
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                //다음 블록 지나갈 수 있는지 판단
                if(j+1<n && cityMap[i][j+1] != 1){
                    //자유롭게 이동
                    if(cityMap[i][j] == 0){
                        if(i==0 && j==0){
                            v[i][j+1].row += 1;     //시작점이므로
                        }
                        else{
                            v[i][j+1].row += v[i][j].row + v[i][j].col;
                        }
                    }
                    //보행자 안전
                    else if(cityMap[i][j]==2){
                        v[i][j+1].row += v[i][j].row;
                    }
                    
                    //경로 수 나누기
                    v[i][j+1].row %= MOD;
                }
                
                if(i+1<m && cityMap[i+1][j] != 1){
                    if(cityMap[i][j]==0){
                        if(i==0 && j==0){
                            v[i+1][j].col += 1;
                        }
                        else{
                            v[i+1][j].col += v[i][j].col + v[i][j].row;
                        }
                    }
                    else if(cityMap[i][j]==2){
                        v[i+1][j].col += v[i][j].col;
                    }
                    
                    v[i+1][j].col %= MOD;
                }
            }
        }
        
        answer = (v[m-1][n-1].col + v[m-1][n-1].row) % MOD;
        
        return answer;
    }
}
