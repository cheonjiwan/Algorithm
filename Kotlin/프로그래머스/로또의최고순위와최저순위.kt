class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf(0,0)
        var nonzeroList = mutableListOf<Int>()

        for (i in 0 until lottos.size){
            if(lottos[i]!=0) {
                nonzeroList.add(lottos[i])
            }
        }

        var zeroCount = 6 - nonzeroList.size
        var count = 0
        for (num1 in nonzeroList){
            for(num2 in win_nums){
                if(num1==num2)
                    count++
            }
        }

        answer[0] = if (zeroCount+count<2) 6 else 7-(zeroCount+count)
        answer[1] = if (count<2) 6 else 7-count

        return answer
    }
}

fun main(args: Array<String>){
    println(Solution().solution(intArrayOf(44,1,0,0,31,25), intArrayOf(31,10,45,1,6,19)))
}