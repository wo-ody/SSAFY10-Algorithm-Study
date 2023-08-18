import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int D;
	static long[] buildings = {1, 0, 0, 0, 0, 0, 0, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		D = Integer.parseInt(br.readLine());
		
		move();
		System.out.println(buildings[0]);
	}
	
	static void move() {
		long [] array = new long[8];
		for(int i=0; i<D; i++) {
			array[0] = buildings[1] + buildings[2];
			array[1] = buildings[0] + buildings[2]+ buildings[3];
			array[2] = buildings[0] + buildings[1]+ buildings[3]+ buildings[4];
			array[3] = buildings[1] + buildings[2]+ buildings[4]+ buildings[5];
			array[4] = buildings[2] + buildings[3]+ buildings[5]+ buildings[6];
			array[5] = buildings[3] + buildings[4]+ buildings[7];
			array[6] = buildings[4] + buildings[7];
			array[7] = buildings[5] + buildings[6];
			
			for(int j=0; j<8; j++) {
				array[j] = array[j]%1_000_000_007;
				buildings[j] = array[j];
			}
		}
	}

}
