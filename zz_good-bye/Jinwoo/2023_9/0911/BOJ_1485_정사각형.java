import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		double[][] square = new double[4][2];
		for (int t=0; t<T; t++) {
			for (int i=0; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<2; j++) {
					square[i][j] = Double.parseDouble(st.nextToken());
				}
			}
            List<Double> line = new ArrayList<>();
			for (int i=0; i<3; i++){
                for (int j=i+1; j<4; j++){
                    line.add(Math.pow(square[i][0]-square[j][0], 2) + Math.pow(square[i][1]-square[j][1],2));
                }
            }
            Collections.sort(line);
			int ans=0;
			if (line.get(0).equals(line.get(1)) && line.get(0).equals(line.get(2)) && line.get(0).equals(line.get(3)) && line.get(4).equals(line.get(0)*2) && line.get(5).equals(line.get(0)*2)) ans=1;
			System.out.println(ans);
		}
	}//main

}
