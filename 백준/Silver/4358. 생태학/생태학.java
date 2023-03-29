import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>();
        int cnt = 0;
        while (true) {
            String str = br.readLine();

            if (str == null || str.length() == 0) {
                break;
            }

            map.put(str, map.getOrDefault(str, 0) + 1);

            cnt++;
        }

        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (Object key : keys) {
            String tree = (String) key;
            int num = map.get(tree);
            double ratio = (double) (num * 100.0) / cnt;
            bw.write(String.format("%s %.4f\n", tree, ratio));
        }

        bw.flush();
    }
}
