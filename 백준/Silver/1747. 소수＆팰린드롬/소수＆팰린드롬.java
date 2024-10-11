import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        while(true) {
            if(isPrime(n)&&isPalindrome(n)){
                System.out.println(n);
                break;
            }
            n++;
        }
    }

    public static boolean isPrime(int x) {
        if(x == 1) return false;

        for(int i=2; i<=Math.sqrt(x); i++) {
            if(x%i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int x) {
        char[] numbers = String.valueOf(x).toCharArray();
        int s = 0;
        int e = numbers.length - 1;

        while(s<e) {
            if(numbers[s]!=numbers[e]){
                return false;
            }
            s++; e--;
        }
        return true;
    }
}
