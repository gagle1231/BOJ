import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); //자리수
        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);

    }
    public static void DFS(int num, int depth){
        int[] odd = {1,3,5,7,9};
        if(depth == n){
            if(isPrime(num)){
                System.out.println(num);
            }
            return;
        }

        for(int i: odd){
            if(isPrime(num*10+i)) {
                DFS(num * 10 + i, depth + 1);
            }
        }
    }
    public static boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i == 0) return false;
        }
        return true;
    }
}