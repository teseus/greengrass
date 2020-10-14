package trainingwear.smtion;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        HashMap reserveMap = new HashMap();

        for (int i = 0; i < reserve.length; i++) {
            reserveMap.put(reserve[i], 1);
        }

        for (int i = 0; i < lost.length; i++) {
            if (reserveMap.remove(lost[i]) != null) {
                lost[i] = 0;
            }
        }

        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == 0) continue;
            if (reserveMap.remove(lost[i]-1) == null && reserveMap.remove(lost[i]+1) == null) {
                answer--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        assertEquals(5, new Solution().solution(5, new int[]{2, 4}, new int[] {1, 3, 5}));
        assertEquals(4, new Solution().solution(5, new int[]{2, 4}, new int[] {3}));
        assertEquals(5, new Solution().solution(5, new int[]{2, 4}, new int[] {2,4}));
        assertEquals(5, new Solution().solution(5, new int[]{2, 4}, new int[] {2,5}));
        assertEquals(6, new Solution().solution(7, new int[]{2, 4}, new int[] {2, 7}));
        assertEquals(4, new Solution().solution(5, new int[]{1, 2, 3}, new int[] {2, 3, 4}));
        assertEquals(4, new Solution().solution(5, new int[]{2, 3, 4}, new int[] {1, 2, 3}));
        assertEquals(5, new Solution().solution(5, new int[]{1, 2, 3}, new int[] {1, 2, 4}));
        assertEquals(2, new Solution().solution(3, new int[]{3}, new int[] {1}));
        assertEquals(1, new Solution().solution(1, new int[]{1}, new int[] {1}));
        assertEquals(3, new Solution().solution(3, new int[]{2}, new int[] {1,3}));
        assertEquals(4, new Solution().solution(5, new int[]{1}, new int[] {4,5}));
    }
}
