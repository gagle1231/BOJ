import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Integer m = sc.nextInt();
        Integer n = sc.nextInt();
        boolean[] isNotPrime = new boolean[n+1];
        isNotPrime[1] = true;
        int cnt = 0;
        int min = -1;
        for(int i=2; i<Math.sqrt(n); i++){
            if(isNotPrime[i]) continue;
            for(int j=2; i*j<=n; j++){
                isNotPrime[i*j] = true;
            }
        }
        for(int i=m; i<=n; i++){
            if(!isNotPrime[i]){
                cnt+=i;
                if(min == -1) min = i;
            }
        }
        if(cnt>0)
            System.out.println(cnt);
        System.out.println(min);
    }
}