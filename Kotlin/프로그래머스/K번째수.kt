class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        for (command in commands){
            var arr = array.sliceArray((command[0]-1) until command[1]).sortedArray()
            answer+=arr[command[2]-1]
        }
        return answer
    }
}

fun main(args: Array<String>){
    var arr1 = intArrayOf(2,5,3)
    var arr2 = intArrayOf(4,4,1)
    var arr3 = intArrayOf(1,7,3)
    var arr : Array<IntArray> = arrayOf(arr1,arr2,arr3)
    println(Solution().solution(intArrayOf(1,5,2,6,3,7,4), arr))
}