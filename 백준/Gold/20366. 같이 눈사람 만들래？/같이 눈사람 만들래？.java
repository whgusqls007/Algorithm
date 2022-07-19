import java.util.*;
import java.io.*;

class Snowman {
	int x1;
	int x2;
	int sum;

	public Snowman(int x1, int x2, int sum) {
		super();
		this.x1 = x1;
		this.x2 = x2;
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "Snowman [x1=" + x1 + ", x2=" + x2 + ", sum=" + sum + "]";
	}

}

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		List<Snowman> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				list.add(new Snowman(i, j, arr[i] + arr[j]));
			}
		}

		Collections.sort(list, (e1, e2) -> Integer.compare(e1.sum, e2.sum));
//		list.forEach(e -> System.out.println(e));

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < list.size() - 1; i++) {

			if (list.get(i).x1 == list.get(i + 1).x1) {
				continue;
			}

			if (list.get(i).x1 == list.get(i + 1).x2) {
				continue;
			}

			if (list.get(i).x2 == list.get(i + 1).x1) {
				continue;
			}

			if (list.get(i).x2 == list.get(i + 1).x2) {
				continue;
			}

			min = Math.min(min, Math.abs(list.get(i).sum - list.get(i + 1).sum));
            if(min == 0) {
                break;
            }
		}

		System.out.println(min);
	}
}
