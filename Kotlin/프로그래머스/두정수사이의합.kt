import kotlin.math.max
import kotlin.math.min

class Solution {
    fun solution(a: Int, b: Int): Long {
        var answer:Long = 0
        val start:Int
        val end:Int

        start = min(a,b)
        end = max(a,b)

        for (i in start..end) {
            answer+=i
        }

        return answer
    }
}

fun main(args: Array<String>){
    print(Solution().solution(3,5))
}

