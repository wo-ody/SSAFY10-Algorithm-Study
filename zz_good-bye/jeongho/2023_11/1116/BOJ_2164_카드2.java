package algorithm2023.nov.day16;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BOJ_2164_카드2 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	   
	   public static void main(String[] args) throws NumberFormatException, IOException {
		   int N = Integer.parseInt(br.readLine());
		   Queue<Integer> q = new LinkedList<>();
		   for(int i= 0;i<N;i++) {
			   q.add(i+1);
		   }
		   while(q.size()>1) {
			  	q.poll();
			  	q.add(q.poll());
		   }
		   bw.write(q.poll()+"\n");
		   bw.flush();
		   bw.close();
		   
	   }
}
