import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader  br   = new BufferedReader(new InputStreamReader(System.in));
		int             N    = Integer.parseInt(br.readLine());
		StringTokenizer st   = new StringTokenizer(br.readLine());
		List<Integer>   list = new ArrayList<>();
		
		list.add(Integer.parseInt(st.nextToken()));

		for (int i = 1; i < N; i++) {
			boolean flag = true;
			int     num  = Integer.parseInt(st.nextToken());
			for (int j = 0; j < list.size(); j++) {
				if (list.get(j) >= num) {
					list.remove(j);
					list.add(j, num);
					flag = false;
					break;
				}
			}
			if (flag) list.add(num);
		}

		System.out.println(list.size());
	}
}