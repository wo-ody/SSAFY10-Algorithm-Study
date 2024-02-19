public class Solution {
	static private int[] res = new int[11];//점수차가 최대일때 라이언이 쏜 화살배열
	static private int[] lion= {-1};//정답배열
	static private int max = Integer.MIN_VALUE;//최대값
    public static int[] solution(int n, int[] info) {
        back(0,n,info);//라이언이 쏜 화살에 대한 조합
        
        if(max==-1) {//라이언이 어피치를 못 이길떄
        	lion = new int[1];
        	lion[0]=-1;
        }
        return lion;
    }
    
    public static void back(int depth, int n, int[] info) {
    	//화살 다 꽂았을때(종료조건)
    	if(depth==n) {
    		int diff = score(info);//점수차 구하기
    		if(max<=diff) {//점수차 최대값 갱신
    			max = diff;
    			lion = res.clone();
    		}
    		return;
    	}
    	
    	//res[i]<=info[i] -> i과녁에 라이언이 화살을 더 많이 맞추면 반복문 종료한다.
    	for(int i=0; i<info.length && res[i]<=info[i]; i++) {
    		res[i] += 1;
    		back(depth+1, n, info);
    		res[i] -= 1;
    	}
    }
    
    //점수차 구하기
    public static int score(int[] info) {
    	int apeach=0, lion=0;
    	for(int i=0; i<res.length; i++) {
    		if(info[i]==0 && res[i]==0) continue;//i원소에 둘다 0개 맞췄을땐 무시.
    		if(info[i]>=res[i]) apeach += (10-i);
    		else lion += (10-i);
    	}
    	
    	int diff = lion - apeach;
    	if(diff<=0) return -1;
    	return diff;
    }
}
