import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	static ArrayList<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		recursion(1, 2, 3, N);
		bw.write(list.size() + "\n");
		for(int i = 0; i < list.size(); i++) {
			int[] temp = list.get(i);
			bw.write(temp[0] + " " + temp[1] + "\n");
		}
		bw.flush();
	}

	static void recursion(int from, int mid, int to, int N){
		if(N==1){
			//int[] temp = {from, to};
			list.add(new int[]{from, to});
			return;
		}
		recursion(from, to, mid, N - 1);
		//int[] temp = {from, to};
		list.add(new int[]{from, to});
		recursion(mid, from, to, N - 1);
	}
}