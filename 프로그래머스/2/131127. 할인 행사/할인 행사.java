import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int length = want.length;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(want[i], number[i]);
        }

        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> currentMap = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                currentMap.put(discount[i + j], currentMap.getOrDefault(discount[i + j], 0) + 1);
            }

            boolean valid = true;
            for (String key : map.keySet()) {
                if (currentMap.getOrDefault(key, 0) != map.get(key)) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                answer++;
            }
        }

        return answer;
    }
}
