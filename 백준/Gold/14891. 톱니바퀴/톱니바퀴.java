import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] gear = new char[4][8]; //각 기어의 극(원형큐)
        int head[] = new int[4]; //각 기어의 헤드
        for(int i=0; i<4; i++){
            gear[i] = br.readLine().toCharArray();
            head[i] = 0;
        }
        int n = Integer.parseInt(br.readLine()); //총 회전 횟수


        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gn = Integer.parseInt(st.nextToken()) - 1;
            int direction = Integer.parseInt(st.nextToken()); //1: 시계방향, -1: 반시계방향
            int rp = (head[gn] + 2) % 8; //선택한 기어의 오른쪽 극
            int lp = (head[gn] + 6) % 8; //선택한 기어의 왼쪽 극
            head[gn] = turn(head[gn], direction);
            int dir = direction *(-1);
            //오른쪽 기어들 회전
            for(int j=gn+1; j<4; j++){
                int pole = (head[j] + 6) % 8; //왼쪽 극
                if(j > 0 && gear[j-1][rp] != gear[j][pole]) { //왼쪽 기어의 오른쪽 극과 극이 다르면 회전
                    rp = (head[j] + 2) % 8;
                    head[j] = turn(head[j], dir);
                    dir*=-1;
                }else{
                    break;
                }
            }
            dir = direction *(-1);
            //왼쪽 기어들 회전
            for(int j=gn-1; j>=0; j--){
                int pole = (head[j] + 2) % 8; //오른쪽 극
                if(j<3 && gear[j+1][lp] != gear[j][pole]) { //오른쪽 기어의 왼쪽 극과 극이 다르면 회전
                    lp = (head[j] + 6) % 8;
                    head[j] = turn(head[j], dir);
                    dir*=-1;
                }else{
                    break;
                }
            }
        }
        int total = 0;
        for(int i=0; i<4; i++){
            total += (Math.pow(2, i) * (gear[i][head[i]]- '0'));
        }
        System.out.println(total);
    }

    public static int turn(int idx, int dir){
        if(dir == 1){ //시계방향
            return (idx + 7) % 8;
        }else{
            return (idx + 1) % 8;
        }
    }

}