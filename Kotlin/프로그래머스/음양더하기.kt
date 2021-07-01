class Solution {
    fun solution(absolutes: IntArray, signs: BooleanArray): Int {
        var answer: Int = 0
        for (i in 0 until signs.size){
            when(signs[i]){
                true -> answer+=absolutes[i]
                false -> answer-=absolutes[i]
            }
        }
        return answer
    }
}

fun main(args: Array<String>){
    println(Solution().solution(intArrayOf(4,7,12), booleanArrayOf(true,false,true)))
}