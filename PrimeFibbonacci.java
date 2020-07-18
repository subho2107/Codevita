import java.io.*;
import java.util.*;

public class PrimeFibbonacci {
    final private static int MAX = 100000;
    private static int [] primes = new int[MAX];
    static void precompute()
    {
        for (int pos = 0; pos < MAX; pos++) {
            primes[pos] = pos;
        }
        for (int num = 2; num*num < MAX ; num++) {
            if (primes[num] == num) {
                for (int num2 = num * num; num2 < MAX; num2 += num) {
                    if (primes[num2]==num2)
                    {
                        primes[num2] = num;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String [] inp = buffer.readLine().split(" ");
        precompute();
        int n1 = Integer.parseInt(inp[0]), n2 = Integer.parseInt(inp[1]);
        HashSet<Integer> primesInBetwn = new HashSet<Integer>();
        for (int num = n1; num < n2+1; num++) {
            if (primes[num]==num) {
                primesInBetwn.add(num);
            }
        }
        int cnt = 0;
        long maxNum = Integer.MIN_VALUE, minNum = Integer.MAX_VALUE;
        HashSet<Integer>a = new HashSet<Integer>();
        for (int prime1: primesInBetwn) {
            for (int prime2:primesInBetwn) {
                if (prime1==prime2)continue;
                int num = Integer.parseInt(Integer.toString(prime1)+Integer.toString(prime2));
                if (primes[num]==num && !a.contains(num))
                {
                    a.add(num);
                    cnt++;
                    maxNum = Math.max(maxNum,num);
                    minNum = Math.min(minNum, num);
                }
            }
        }
        for (int pos = 2; pos < cnt; pos++) {
            long temp = minNum;
            minNum = maxNum;
            maxNum += temp;
        }
        sb.append(maxNum);
        System.out.println(sb);
    }
}