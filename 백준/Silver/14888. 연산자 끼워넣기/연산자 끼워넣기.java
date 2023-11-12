import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int[] op; //연산자 개수 담은거
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        op = new int[4];
        StringTokenizer str = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(str.nextToken());
        }
        //0:+, 1:-, 2:*, 3:/
        str = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++){
            op[i] = Integer.parseInt(str.nextToken());
        }
        solution(0, n-1, arr[0]);
        System.out.println(max);
        System.out.println(min);

    }
    public static void solution(int d, int r, int result){
        if(d==r){
            max = Math.max(result, max);
            min = Math.min(result, min);
        }

        for(int i=0; i<4; i++){
            if(op[i]>0){
                op[i]--;
                solution(d+1, r, cal(result, arr[d+1], i));
                op[i]++;
            }
        }
    }
    public static int cal(int a, int b, int o){
        if(o==0) return a+b;
        else if(o==1) return a-b;
        else if(o==2) return a*b;
        else if(o==3){
            return b == 0 ? b: a/b;
        }
        return 0;
    }

}