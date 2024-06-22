import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        String num = sc.next();
        char[] arr = num.toCharArray();
        for(char c: arr){
            sum += c - '0';
        }
        System.out.println(sum);
    }
}