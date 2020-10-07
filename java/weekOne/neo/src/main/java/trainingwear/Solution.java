package trainingwear;

import static org.junit.Assert.assertEquals;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = 1;
        }
        for (int i : lost) {
            int idx = i - 1;
            students[idx] = 0;
        }
        for (int i : reserve) {
            int idx = i - 1;
            if(students[idx] == 0)
                students[idx] = 1;
            else if (idx > 1 && students[idx-1]==0)
                students[idx-1] = 1;
            else if (idx < n-1 && students[idx+1]==0)
                students[idx+1] = 1;
        }
        int sum = 0;
        for (int student : students) {
            sum += student;
        }
        return sum;
    }

    public static void main(String[] args) {
        assertEquals(5, new Solution().solution(5, new int[]{2, 4}, new int[] {1, 3, 5}));
        assertEquals(4, new Solution().solution(5, new int[]{2, 4}, new int[] {3}));
        assertEquals(5, new Solution().solution(5, new int[]{2, 4}, new int[] {2,4}));
        assertEquals(5, new Solution().solution(5, new int[]{2, 4}, new int[] {2,5}));
        assertEquals(6, new Solution().solution(7, new int[]{2, 4}, new int[] {2, 7}));
        assertEquals(4, new Solution().solution(5, new int[]{1, 2, 3}, new int[] {2, 3, 4}));
        assertEquals(5, new Solution().solution(5, new int[]{1, 2, 3}, new int[] {1, 2, 4}));
        assertEquals(1, new Solution().solution(1, new int[]{1}, new int[] {1}));
    }
}
