import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = {-10, 1, 10, -1};
        int[][] board = new int[n][n];
        List<Coor> snake = new ArrayList<>();
        //뱀: 1, 사과 2, 0빈칸
        snake.add(new Coor(0, 0));
        board[0][0] = 1;
        for(int i=0; i<k; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            board[x-1][y-1] = 2;
        }
        int l = sc.nextInt();
        int direction = 1; //현재 방향, 시작은 오른쪽
        int cnt = 0;
        boolean isFinish = false;
        int before = 0;
        int xp = 0, yp = 0;
        for(int i=0; i<l; i++){
            int x = sc.nextInt(); //시작부터 경과한 시간
            String c = sc.next(); //방향 회전
            if(!isFinish){
                xp = arr[direction]/10;
                yp = arr[direction]%10;
                for(int j=0; j<x-before; j++){
                    Coor head = snake.get(0);
                    cnt++;
                    int xc = head.x + xp;
                    int yc = head.y + yp;
                    if(xc < 0 || xc >= n){
                        isFinish = true;
                        break;
                    }
                    if(yc < 0 || yc >= n){
                        isFinish = true;
                        break;
                    }

                    if(board[xc][yc] == 1){
                        isFinish = true;
                        break;
                    }else if(board[xc][yc] == 2){
                        snake.add(0, new Coor(xc, yc));
                        board[xc][yc] = 1;
                    }else{
                        Coor tail  = snake.remove(snake.size()-1);
                        snake.add(0, new Coor(xc, yc));
                        board[tail.x][tail.y] = 0;
                        board[xc][yc] = 1;
                    }
                }
                direction = changeDirection(c, direction);
                before = cnt;
            }
        }
        if(isFinish){
            System.out.println(cnt);
        }else {
            int i=1;
            Coor head = snake.get(0);
            xp = arr[direction]/10;
            yp = arr[direction]%10;
            int x = head.x + xp;
            int y = head.y + yp;
            while (x>=0 && x<n && y >=0 && y<n && board[x][y]!=1){
                x = x + xp;
                y = y +yp;
                i++;
            }
            System.out.println(cnt+i);
        }

    }
    public static class Coor{
        int x;
        int y;
        public Coor(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static int changeDirection(String c, int direction){
        //System.out.println(c);
        if(c.equals("L")){//시계 반대 방향
            direction = (direction+3)%4;
        }else{
            direction= (direction+1)%4;
        }
        return direction;
    }
}