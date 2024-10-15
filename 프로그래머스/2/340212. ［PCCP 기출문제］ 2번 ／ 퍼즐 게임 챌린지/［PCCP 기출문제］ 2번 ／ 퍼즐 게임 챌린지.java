class Solution {
    public long solution(int[] diffs, int[] times, long limit) {
        int maxDifficulty = 0;
        for (int diff : diffs) {
            maxDifficulty = Math.max(maxDifficulty, diff);
        }

        int min = 1;
        int max = maxDifficulty;
        int answer = 0;

        while (min <= max) {
            int mid = (min + max) / 2;
            if (canComplete(mid, diffs, times, limit)) {
                answer = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return answer;
    }

    private boolean canComplete(int level, int[] diffs, int[] times, long limit) {
        long totalTime = 0;
        int prev = 0;
        for (int i = 0; i < diffs.length; i++) {
            if (level >= diffs[i]) {
                totalTime += times[i];
            } else {
                totalTime += (long) (times[i] + prev) * (diffs[i] - level) + times[i];
            }
            if (totalTime > limit) {
                return false; // 제한 시간을 초과하면 false 반환
            }
            prev = times[i];
        }
        return true; // 제한 시간 내에 완료 가능하면 true 반환
    }
}
