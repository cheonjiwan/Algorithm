class Solution {
    fun solution(s: String): String {
        var answer = ""
        var len = s.length/2
        if(s.length%2==0){
            return s.substring(len-1..len)
        }
        else
            return s.substring(len..len)
    }
}

fun main(args: Array<String>){
    println(Solution().solution("abcde"))
}