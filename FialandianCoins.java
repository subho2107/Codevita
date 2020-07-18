import java.io.*;
import java.util.*;

public class FialandianCoins {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(buffer.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(buffer.readLine());
            sb.append((Integer.toBinaryString(n).length())+"\n");
        }
        System.out.println(sb);
    }
}
