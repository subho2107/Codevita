import java.io.*;
import java.util.*;

public class Swayamvar {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(buffer.readLine());
        List<Character> bridetoBe = new ArrayList<>();
        List<Character> groomToBe = new ArrayList<>();
        char [] a = buffer.readLine().toCharArray();
        for (int pos = 0; pos < n; pos++) {
            bridetoBe.add(a[pos]);
        }
        a = buffer.readLine().toCharArray();
        for (int pos = 0; pos < n; pos++) {
            groomToBe.add(a[pos]);
        }
        while (groomToBe.size()!=0 && bridetoBe.size()!=0 && groomToBe.contains(bridetoBe.get(0)))
        {
            char temp = bridetoBe.get(0);
            while (temp!=groomToBe.get(0))
                groomToBe.add(groomToBe.remove(0));
            bridetoBe.remove(0);
            groomToBe.remove(0);
        }
        sb.append(groomToBe.size());
        System.out.println(sb);
    }
}
