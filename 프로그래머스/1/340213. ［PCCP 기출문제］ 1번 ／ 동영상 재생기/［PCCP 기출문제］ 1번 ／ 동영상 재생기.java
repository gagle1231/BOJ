class Solution {
    public static int current;
    public static int MAX_TIME;
    public static int OP_START;
    public static int OP_END;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        current = convertToSec(pos);
        MAX_TIME = convertToSec(video_len);
        OP_START = convertToSec(op_start);
        OP_END = convertToSec(op_end);
        
        if(current >= OP_START && current <= OP_END) {
                current = OP_END;
        }
        for(String command: commands) {
            if(command.equals("next")) {
                current+=10;
            } else if (command.equals("prev")) {
                current -= 10;
            }
            
            if(current < 0 ){
                current = 0;
            }else if(current >= MAX_TIME) {
                current = MAX_TIME;
            }
            if(current >= OP_START && current <= OP_END) {
                current = OP_END;
            }
        }
        
        int min = current/60;
        int sec = current%60;
        answer = String.format("%02d:%02d", min, sec);
        return answer;
    }
    
    public static int convertToSec(String str) {
        String[] temp = str.split(":");
        int min = Integer.parseInt(temp[0]);
        int sec = Integer.parseInt(temp[1]);
        
        return sec + min * 60;
    }
    
}