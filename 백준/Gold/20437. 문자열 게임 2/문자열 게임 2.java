import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            String str = br.readLine();
            int k = Integer.parseInt(br.readLine());
            solution(str, k);
        }
    }

    public static void solution(String word, int k) {
        int n = word.length();
        int minLength = Integer.MAX_VALUE;
        int maxLength = Integer.MIN_VALUE;
        boolean found = false;

        for (char ch = 'a'; ch <= 'z'; ch++) {
            LinkedList<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                if (word.charAt(i) == ch) {
                    queue.add(i);
                }
                if (queue.size() == k) {
                    int length = queue.getLast() - queue.getFirst() + 1;
                    minLength = Math.min(minLength, length);
                    maxLength = Math.max(maxLength, length);
                    queue.poll();
                    found = true;
                }
            }
        }

        if (found) {
            System.out.println(minLength + " " + maxLength);
        } else {
            System.out.println(-1);
        }
    }
}
