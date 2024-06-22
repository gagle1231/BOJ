import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int cnt = 1;
        int sum=1;
        int s=1, e=1;
        while(e<n){
            if(sum == n) {
                cnt++;
                e++;
                sum = sum + e;
            }else if(sum < n){
                e++;
                sum +=e;
            }else{
                sum-=s;
                s++;
            }
        }
        System.out.println(cnt);
    }
}