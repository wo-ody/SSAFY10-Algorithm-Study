import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] arr = new char[2][2];
		char[] ar = new char[2];
		String b = br.readLine();
		switch (b) {
		case ("S") :
			arr[0] = br.readLine().toCharArray();
			arr[1] = br.readLine().toCharArray();
			break;
		case ("N") :
			arr[1] = br.readLine().toCharArray();
			arr[0] = br.readLine().toCharArray();
			char t = arr[0][0]; arr[0][0] = arr[0][1]; arr[0][1] = t;
			t = arr[1][0]; arr[1][0] = arr[1][1]; arr[1][1] = t;
			break;
		case ("E") :
			ar = br.readLine().toCharArray();
			arr[0][1] = ar[0]; arr[1][1] = ar[1];
			ar = br.readLine().toCharArray();
			arr[0][0] = ar[0]; arr[1][0] = ar[1];
			break;
		case ("W") :
			ar = br.readLine().toCharArray();
			arr[1][0] = ar[0]; arr[0][0] = ar[1];
			ar = br.readLine().toCharArray();
			arr[0][1] = ar[1]; arr[1][1] = ar[0];
			break;
		}
		String a = ""+arr[0][0]+arr[0][1]+arr[1][0]+arr[1][1];
		switch (a) {
		case ("I..P") : System.out.println("F"); break;
		case (".OP.") : System.out.println("T"); break;
		case ("O..P") : System.out.println("Lz"); break;
		default: System.out.println("?");
		}
	}

}
