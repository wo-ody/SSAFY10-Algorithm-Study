package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//입력
//사진 틀의 개수 1<=N<=20 
//전체 학생 총 추천 횟수 <=1000
//추천 받은 학생 번호 한 줄로 

//추천받으면 -> 사진 틀에 개시(사진 틀 하나에 한 학생의 추천들만)
//틀이 다 차면 가장 적은 추천을 받은 학생을 삭제 -> 추천 수도 0으로 줄어듬
//가장 적은 추천을 받은 학생이 여러명이면, 더 이전에 추천 받은 학생이 사라짐.

//최종 후보들의 번호 출력하기
public class BOJ1713{
	//N = pictureNum
	//M = total
	// student = student
	//vote = commend
	//time = photo
	static int N,M,now,changeIdx;
	static int[] student;
	static int[] vote;
	static int[] photo;
	

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		//사진틀 개수 N 입력받기
		N = Integer.parseInt(st.nextToken());
		student = new int[N];//학생 번
		vote = new int[N];//추천 
		photo = new int[N];//게시 순
		
		st = new StringTokenizer(br.readLine());
		//추천 횟수 M 입력받기
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		for(int x=0; x<M; x++) {
			now = Integer.parseInt(st.nextToken());
			changeIdx = 0;
			
			for(int y = 0; y<N; y++) {
				//사진들이 비어있거나, 이미 게시된 경우
				if(student[y] == 0 || student[y] == now) {
					changeIdx = y;//해당 좌표에 사진넣기
					break;
				}
				
				//추천 횟수가 더 적거나, 추천 횟수가 같고 먼저 사진에 게시된 경우    
				if(vote[changeIdx] > vote[y] || (vote[changeIdx] == vote[y] && photo[changeIdx] > photo[y])) {
					changeIdx = y;
				}
			}
			
			//게시되어있는 학생과 현재 게시하는학생이 다른 경우에 추천횟수는 초기화하고, 사진 게시 순서도 초기화해준다. 
			if(student[changeIdx]!=now) {
				student[changeIdx] = now;
				vote[changeIdx] = 0;
				photo[changeIdx] = x;
			}
			
			vote[changeIdx]++; //추천횟수 증
			
		}
		
		Arrays.sort(student);
		
		for(int x:student) {
			if(x!=0) //사진틀에 학생이 없을 수도 있음...!!!!!!추천되는 학생 가지수가 적으면 
				sb.append(String.valueOf(x)).append(" ");
		}
		
		System.out.println(sb);
	}

}
