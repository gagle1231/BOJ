class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = -1;
        int start = toSec(h1, m1, s1);
        int end = toSec(h2, m2, s2);

        int startAlarm = countAlarm(start); // 시작시간까지 알람 울린 횟수
        int endAlarm = countAlarm(end); // 종료시간까지 알람 울린 횟수
        answer = endAlarm - startAlarm;

        if(start*59%3600==0 || start*719%43200==0){ // 현재 알람 울리는 중인지 체크
            answer++;
        }

        return answer;
    }

    // 00시부터 지금까지 해당 시간에 알람이 울린 횟수 구하기
    public static int countAlarm(int time){
        int minAndSec = time * 59 / 3600; // 분침과 초침이 만난 횟수
        int hourAndSec = time * 719 / 43200; // 시침과 초침이 만난 횟수

        int count12 = time >= 43200 ? 2 : 1; //12:00:00의 횟수, time이 43200 이상이면(24시간 이상) 2번 울림
        return minAndSec + hourAndSec - count12;
    }
    // 시간을 초 단위로 환산
    public static int toSec(int h, int m, int s){
        return h*3600 + m*60 +s;
    }
}