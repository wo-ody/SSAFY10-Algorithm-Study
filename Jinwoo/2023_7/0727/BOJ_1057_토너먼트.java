import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int kim = Integer.parseInt(str[1]);
		int im = Integer.parseInt(str[2]);
        int answer = 0;
		if(n%2 != 0) {
			n+= 1;
		}
		while(kim != im){
	            kim = (kim+1)/2;
	            im = (im+1)/2;
	            answer++;
	    }
	    System.out.println(answer);
	}

}
