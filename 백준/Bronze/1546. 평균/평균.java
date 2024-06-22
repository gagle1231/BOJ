import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        float[] arr = new float[n];
        float m = 0;
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
            m = m < arr[i] ? arr[i] : m;
        }
        float sum = 0;
        for(int i=0; i<n; i++){
            sum += (arr[i]/m)*100;
        }
        System.out.println(sum/n);
    }
}