import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t = Integer.parseInt(st.nextToken());
        for(int i=0; i<t; i++){
            String str = br.readLine();
            int w = Integer.parseInt(br.readLine());
            solution(str, w);
        }
    }
    public static void solution(String word, int w){
        int[] alpha = new int[27];
        int size = word.length();
        for(char c: word.toCharArray()){
            alpha[c - 'a']++;
        }

        int max = 0;
        int min = size + 1;
        for(int i=0; i<size-w+1; i++){
            char c = word.charAt(i);
            if(alpha[c-'a'] < w) continue;
            int cnt=0;
            for(int j=i; j<size; j++){
                if (word.charAt(j) == c) cnt++;
                if(cnt == w){
                    int len = j - i + 1;
                    min = min > len ? len : min;
                    max = max > len ? max : len;
                    break;
                }
            }
        }
        if(max == 0) System.out.println(-1);
        else System.out.println(min+" "+max);

    }
}