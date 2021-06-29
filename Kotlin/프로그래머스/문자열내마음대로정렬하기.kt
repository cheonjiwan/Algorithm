class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        return strings.sorted().sortedWith(compareBy({it[n]},{it})).toTypedArray()
    }
}

fun main(args: Array<String>){
    var strings :Array<String> = arrayOf<String>("sun","bed","car")
    var n = 5

    print(Solution().solution(strings,1).toString())
}

