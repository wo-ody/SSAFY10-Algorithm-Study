import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>();
		Set<String> result = new TreeSet<>();

		while (true) {
			String s = br.readLine();
			if (s.equals("000-00-0000"))
				break;

			if (!set.contains(s))
				set.add(s);
			else {
				result.add(s);
			}
		}
		result.forEach(System.out::println);
	}
}