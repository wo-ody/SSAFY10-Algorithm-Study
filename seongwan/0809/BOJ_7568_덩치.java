import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class person{
	int x;
	int y;
	int rank;
	person(int x, int y){
		this.x =x;
		this.y =y;
	}
}

public class Main {
	static BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static person[] people;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	 int N= Integer.parseInt(br.readLine());
	 
	 people=new person[N];
	 for (int i = 0; i < N; i++) {
		 st=new StringTokenizer(br.readLine());
		 people[i]=new person(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
		
	}
	 for (int i = 0; i < N; i++) {
		 int chk=0;
		 for (int j = 0; j < N; j++) {
			if(people[i].x<people[j].x&&people[i].y<people[j].y) {
				chk++;
			}
		}
		
	people[i].rank=1+chk;
	}

	for (int i = 0; i < N; i++) {
		System.out.print(people[i].rank+" ");
	}}

}
