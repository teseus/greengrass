package trainingwear;

import static org.junit.Assert.assertEquals;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n];
        for (int i = 0; i < n; i++) {
            students[i] = 1;
        }
        for (int i : lost) {
            students[i - 1] = 0;
        }

        for (int i: reserve) {
            students[i - 1] = ++students[i - 1];
        }

        int sum = 0;
        for (int i = 0; i < students.length; i++) {
            if(students[i] == 0){
                if(i > 0 && students[i-1] == 2) {
                    students[i-1]--;
                    students[i]++;
                } else if(i < n-1 && students[i+1] == 2) {
                    students[i+1]--;
                    students[i]++;
                }
            }
            sum += students[i]>0?1:0;
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
        assertEquals(4, new Solution().solution(5, new int[]{2, 3, 4}, new int[] {1, 2, 3}));
        assertEquals(5, new Solution().solution(5, new int[]{1, 2, 3}, new int[] {1, 2, 4}));
        assertEquals(2, new Solution().solution(3, new int[]{3}, new int[] {1}));
        assertEquals(1, new Solution().solution(1, new int[]{1}, new int[] {1}));
        assertEquals(3, new Solution().solution(3, new int[]{2}, new int[] {1,3}));
        assertEquals(4, new Solution().solution(5, new int[]{1}, new int[] {4,5}));
    }
}
