import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		String             str = new BufferedReader(new InputStreamReader(System.in)).readLine();
		StringTokenizer    st  = new StringTokenizer(str, "+-", true);
		ArrayList<Integer> al  = new ArrayList<Integer>();
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if (!st.hasMoreTokens()) {
				al.add(num);
				break;
			}
			char oper = st.nextToken().charAt(0);
			if (oper == '-') al.add(num);
			else {
				while (true) {
					num += Integer.parseInt(st.nextToken());
					if (!st.hasMoreTokens()) {
						al.add(num);
						break;
					}
					char nextOper = st.nextToken().charAt(0);
					if (nextOper == '-') {
						al.add(num);
						break;
					}
				}
			}
		}

		int result = al.get(0);
		for (int i = 1; i < al.size(); i++) {
			result -= al.get(i);
		}

		System.out.println(result);
	}
}