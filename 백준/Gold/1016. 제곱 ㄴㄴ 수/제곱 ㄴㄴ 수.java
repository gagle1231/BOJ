import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] check = new boolean[(int) (max-min+1)];

        for(long i = 2; i * i <= max; i++) {
            long pow = i*i;
            long start_idx = min / pow;
            if(min % pow != 0)
                start_idx++;
            for(long j = start_idx; pow * j <= max; j++) {
                check[(int) ((pow * j) - min)] = true;
            }
        }
        int count = 0;
        for (int i = 0; i <= max-min; i++) {
            if(!check[i]){
                count++;
            }
        }
        System.out.println(count);
    }
}
