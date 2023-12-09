import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] weights;
    static int[] values;
    static int[][] back; //dp용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //n개의 물건
        int k = Integer.parseInt(st.nextToken()); //배낭의 최대 무게 k
        weights = new int[n];
        values = new int[n];
        back = new int[n+1][k+1];
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken()); //물건의 무게
            values[i] = Integer.parseInt(st.nextToken()); //물건의 가치
        }
        
        for(int i=1; i<=n; i++){
            for(int w=1; w<=k; w++){
                if(weights[i-1] > w){
                    back[i][w] = back[i-1][w];
                }else{
                    back[i][w] = Math.max(values[i-1] + back[i-1][w-weights[i-1]], back[i-1][w]);
                }
            }
        }
        System.out.println(back[n][k]);
    }
}