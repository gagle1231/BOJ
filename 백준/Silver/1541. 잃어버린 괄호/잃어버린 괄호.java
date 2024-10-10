import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line =bufferedReader.readLine();

        String[] split = line.split("-"); // -를 기준으로 분리
        int sum = 0;
        for(int i=0; i<split.length; i++) {
            int tmp =0;
            for(String s: split[i].split("\\+")){
                tmp+=Integer.parseInt(s);
            }

            if(i==0) {
                sum += tmp;
            }
            else {
                sum-=tmp;
            }
        }
        System.out.println(sum);
    }
}
