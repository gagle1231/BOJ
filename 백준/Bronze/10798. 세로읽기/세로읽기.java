import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] s = new String[5];
        for(int i=0; i<5; i++){
            s[i] = br.readLine();
        }
        for(int i=0; i<=15; i++){
            for(int j=0; j<5; j++){
                if(s[j].length()>i){
                    sb.append(s[j].charAt(i));
                }
            }
        }
        System.out.println(sb);
    }
}