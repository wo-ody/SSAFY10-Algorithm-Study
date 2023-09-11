package binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_8983_사냥꾼 {
	static int M,N,L,cnt; //사대의 수, 동물의 수, 사정거리, 사냥 가능한 동물의 수 
	static int[] hunterX; // 사냥꾼의 x좌표  
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		hunterX = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			hunterX[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(hunterX);
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int animalX = Integer.parseInt(st.nextToken());
			int animalY = Integer.parseInt(st.nextToken());
			
			int hunter = binarySearch(0, M-1, animalX); //동물의 x좌표를 key로 두고 사냥꾼의 x좌표가 들어있는 배열을 이분탐색  
			
			int l = Math.abs(animalX - hunter) + animalY;
			
			if(l <= L) cnt++;
		}
		
		System.out.println(cnt);

	}
	
	static int binarySearch(int left, int right, int key) {
		int mid = (left + right)/2;
		
		while(left < right) {
			mid = (left + right)/2;
			
			if(hunterX[mid] == key) { //x좌표가 같다면 그때의 사냥꾼이 가장 가까이 있는 사냥꾼  
				return hunterX[mid];
			}else if(hunterX[mid] > key) { //동물의 x좌표보다 크다는건 오른쪽에 있는 사냥꾼이므로 왼쪽 사냥꾼들을 찾아줘야함 
				right = mid;
			}else { // 왼쪽에 있는 사냥꾼이므로 오른쪽에 있는 사냥꾼들을 찾아줘야함 
				left = mid+1;
			}
		}
		//다 돌았을때 같은 값이 없다면 해당 사냥꾼이 가장 ㄱ가까운 사냥꾼 	
		return hunterX[right];
		
	}

}
