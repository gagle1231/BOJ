import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Balloon> balloons = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=n; i++){
            balloons.add(new Balloon(i, Integer.parseInt(st.nextToken())));
        }
        int index = 0;
        Balloon rm;
        StringBuilder sb = new StringBuilder();
        while(!balloons.isEmpty()){
            rm = balloons.remove(index);
            if(balloons.isEmpty()){
                sb.append(rm.index + " ");
                break;
            }
            if(rm.value > 0) index = (index - 1 + rm.value)% balloons.size();
            else index = (index + rm.value) % balloons.size();
            if(index<0) index= balloons.size() + index;
            sb.append(rm.index +" ");
        }
        System.out.print(sb);
    }
    public static class Balloon{
        int index;
        int value;
        public Balloon(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}