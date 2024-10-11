import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            result.append(lcm(a, b))
                    .append("\n");
        }

        System.out.println(result);
    }

    /*
     * 최대 공약수 구하기
     * 유클리드 호제법으로 풀이
     * 1. 큰 수(a)에서 작은수(b)로 나누기
     * 2. 작은수에서 나머지로 나누기 -> 이 때 작은 수를 큰 수로, 나머지를 작은 수로 자리를 옮겨주면 됨
     * 3. 나머지가 0이 될 때 까지 반복, 나머지가 0일 때 작은 수(b)가 답
     * */
    public static int gcd(int a, int b) {
        while (a%b != 0) {
            int mod = a%b;
            a = b;
            b = mod;
        }
        return b;
    }

    /*
    * 최대공약수 구하기
    * LCM(a,b)= ∣a×b∣ /  GCD(a,b)
    * */
    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
}
