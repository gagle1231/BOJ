import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new int[n];
        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            list[i] = Integer.parseInt(st.nextToken());
            if(list[i] > start) start = list[i];
            end+=list[i];
        }

        int lastAvail = end;
        while(start <= end){
            int mid = (start+end)/2;
            int sum = 0;
            int count = 1;
            for(int i: list){
                sum+=i;
                if(sum>mid){
                    count++;
                    sum = i;
                }
            }

            if(count > m){ //이 크기로는 다 수용 못함
                start = mid + 1;
            }else{
                lastAvail = mid;
                end = mid - 1;
            }
        }
        System.out.println(lastAvail);
    }
}