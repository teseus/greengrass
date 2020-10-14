package nexpression;

import static org.junit.Assert.assertEquals;

class Solution {
    public int solution(int N, int number) {
        //곱샘 먼저 하고 작으면 나머지 크면 다시 곱샘
        //크지만 자신보다 작으면 자신을 자신으로 나눠서 빼기 시전.
        // 5 24 ->
        // 5*5 - (5/5), : 4
        // 5+5+5+5 + (5/5) + (5/5) + (5/5) + (5/5)

        // 5 21 ->
        // 5 + 5 + 5+ 5 + (5/5),
        // 5*5-(5/5)-(5/5)-(5/5)-(5/5)
        //남은개 자신보다크면 자신을 더한다 나머지 크면 다시 덧샘
        //남은개 자신보다 작으면 자신을 나눠서 더한다 + 1 끝날때까지.

        int remain = number;
        int sum = N;
        int count = 1;  //처음부터 N 보다 작을 경우는?
        while (remain >= sum * N){
            sum = sum * N;
            count++;
        }
        if( remain == sum ) {
            return getUnder8(count);
        }

        // N 의 배수가 아닌경우 N의 곱셈만큼을 빼고 덧샘으로 계산한다.
        if((sum*N) - remain <= N/2){ //차이가 N보다 작으면
            //자신을 나눠서 1씩 더해가면서 카운트
            return getUnder8((sum * N - remain) * 2 + 1 + count);
        }

        if(remain>sum) {
            remain -= sum;
        } else {
            count = 0;
        }

        //아니면 더해가면서 카운트
        sum = 0; //5
        while(remain >= sum + N) {
            sum = sum + N;
            count ++;
        }
        if( remain == sum ) {
            return getUnder8(count);
        }


        remain -= sum;
        if(N - remain <= N/2){
            return getUnder8((N - remain) * 2 + 1 + count);
        } else {
            return getUnder8(remain * 2 + count);
        }
    }

    private int getUnder8(int count) {
        return count <= 8 ? count : -1;
    }

    public static void main(String[] args) {
        assertEquals(2, new Solution().solution(5, 25)); //곱셉만으로
        assertEquals(8, new Solution().solution(2, 256)); //곱셉만으로
        assertEquals(-1, new Solution().solution(2, 1024)); //곱셉만으로
        assertEquals(-1, new Solution().solution(2, 2048)); //곱셉만으로
        assertEquals(4, new Solution().solution(5, 35)); //곱셈과 덧셈
        assertEquals(4, new Solution().solution(5, 24)); //곱셈과 뺄샘
        assertEquals(5, new Solution().solution(5, 124)); //곰셉과 뺄샘
        assertEquals(3, new Solution().solution(5, 4)); //덧셈과 1뺄생
        assertEquals(4, new Solution().solution(5, 9)); //덧셈과 1뺄생
        assertEquals(5, new Solution().solution(5, 3)); //덧셈과 1뺄생
        assertEquals(5, new Solution().solution(5, 3)); //덧셈과 1뺄생

        assertEquals(4, new Solution().solution(5, 2));//곱셈과 1덧셈
        assertEquals(2, new Solution().solution(5, 1));//곱셈과 1덧셈
        assertEquals(5, new Solution().solution(2, 7));//곱셈과 덧셈과 1뺄셈
        assertEquals(4, new Solution().solution(4, 24));//곱셈과 덧셈과 1뺄셈
        assertEquals(6, new Solution().solution(4, 23));//곱셈과 덧셈과 1뺄셈
        assertEquals(6, new Solution().solution(5, 34));//곱셈과 덧셈과 1뺄셈 5*5 + 5 + 5 - (5/5)
        assertEquals(8, new Solution().solution(5, 33));//곱셈과 덧셈과 1뺄셈
        assertEquals(7, new Solution().solution(5, 32));//곱셈과 덧셈과 1뺄셈 5*5 + 5 + (5/5) + (5/5)
        assertEquals(7, new Solution().solution(5, 32));//곱셈과 덧셈과 1뺄셈 5*5 + 5 + (5/5) + (5/5)
        assertEquals(7, new Solution().solution(5, 32));//곱셈과 덧셈과 1덧샘
        assertEquals(5, new Solution().solution(5, 31));//곱셈과 덧셈과 1덧샘

    }
}
