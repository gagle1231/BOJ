import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] board;
    static List<int[]> listHome;
    static List<int[]> listChicken;
    static int minChickenDistance = Integer.MAX_VALUE;
    static boolean[] isPicked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new int[n][n]; //도시

        listHome = new ArrayList<>();
        listChicken = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1){
                    listHome.add(new int[]{i, j});
                }else if(board[i][j] == 2){
                    listChicken.add(new int[]{i, j});
                }
            }
        }
        isPicked = new boolean[listChicken.size()];
        pick(0, 0, listChicken.size(), m);
        System.out.println(minChickenDistance);
    }

    public static void pick(int toPick, int index, int len, int m){
        if(toPick == m){
            int totalCD = 0;
            for(int i=0; i< listHome.size(); i++){
                int[] home = listHome.get(i);
                int homeX = home[0];
                int homeY = home[1];
                int min = Integer.MAX_VALUE;
                for(int j=0; j<listChicken.size(); j++){
                    if(!isPicked[j]) continue;
                    int[] chicken = listChicken.get(j);
                    int chX = chicken[0];
                    int chY = chicken[1];
                    int t = Math.abs(homeX-chX) + Math.abs(homeY-chY);
                    min = Math.min(min, t);
                }
                totalCD += min;
            }
            minChickenDistance = Math.min(minChickenDistance, totalCD);
        }

        for(int i=index; i<len; i++){
            isPicked[i] = true;
            pick(toPick+1, i+1, len, m);
            isPicked[i] = false;
        }
    }

}