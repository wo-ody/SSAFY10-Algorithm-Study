import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] room = new int[10];
		String number = br.readLine();
		for(int i = 0; i < number.length(); i++){
			if (number.charAt(i) - '0' == 9) room[6] += 1;
			else room[number.charAt(i) - '0'] += 1;
		}
		//for(int i : room) System.out.print(i + " ");
		bw.newLine();
		int fifth = room[6];
		if(room[6] % 2 == 0) room[6] = fifth/2;
		else room[6] = fifth/2 + 1;
		Arrays.sort(room);
		System.out.println(room[9]);
		
		bw.close();
		br.close();
	}
}
