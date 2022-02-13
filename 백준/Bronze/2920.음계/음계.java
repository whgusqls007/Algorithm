import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader  br           = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st           = new StringTokenizer(br.readLine());
		int             prev         = Integer.parseInt(st.nextToken());
		int             cur          = -1;
		boolean         isAscending  = true;
		boolean         isDescending = true;

		for (int i = 0; i < 7; i++) {
			cur = Integer.parseInt(st.nextToken());
			if (isAscending && prev + 1 != cur) {
				isAscending = false;
			}
			if (isDescending && prev - 1 != cur) {
				isDescending = false;
			}
			prev = cur;
		}

		System.out.println(isAscending ? "ascending" :
				isDescending ? "descending" :
				"mixed");
	}
}