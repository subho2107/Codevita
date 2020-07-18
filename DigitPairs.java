import java.io.*;
import java.util.*;

public class DigitPairs {
    static HashMap<Integer, Integer> visited = new HashMap<>();

    public static int getPairCnt(ArrayList<Integer> list) {
        int pairs = 0;
        for (int pos = 0; pos < list.size() - 1; pos++) {
            int a = list.get(pos) / 10;
            for (int pos2 = pos + 1; pos2 < list.size(); pos2++) {
                int b = list.get(pos2) / 10;
                if (a == b && visited.getOrDefault(a, 0) <= 1) {
                    pairs++;
                    visited.put(a, visited.getOrDefault(a, 0) + 1);
                }
            }
        }
        return pairs;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        String[] inp = buffer.readLine().split(" ");
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        for (int pos = 0; pos < n; pos++) {
            String num = inp[pos];
            int a = Integer.parseInt(String.valueOf(num.charAt(0))), b = Integer.parseInt(String.valueOf(num.charAt(1))), c = Integer.parseInt(String.valueOf(num.charAt(2)));
            int score = (Math.max(Math.max(a, b), c) * 11) + (Math.min(Math.min(a, b), c) * 7);
            if (score / 100 != 0)
                score = score % 100;
            if (pos % 2 == 0)
                even.add(score);
            else
                odd.add(score);
        }
        sb.append(getPairCnt(odd) + getPairCnt(even));
        System.out.println(sb);
    }
}
