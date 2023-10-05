import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1259_팰린드롬수 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		char[] array;
		
		while(true) {
			boolean yesOrNo = true;
			String input = br.readLine();
			if(input.equals("0")) break;
			
			array = input.toCharArray();
			int endIdx = array.length-1;
			for (int startIdx = 0; startIdx <= endIdx; startIdx++) {
				if(array[startIdx]-array[endIdx] != 0) {
					yesOrNo = false;
					break;
				}
				endIdx--;
			}
			System.out.println(yesOrNo ? "yes" : "no");
		}
		
	}

}
