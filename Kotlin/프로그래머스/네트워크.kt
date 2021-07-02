import java.util.*;

class Solution {

    lateinit var visited: Array<Boolean>

    fun solution(n: Int, computers: Array<IntArray>): Int {
        var cnt:Int = 0
        var q = LinkedList<Int>();

        visited = Array(n,{false})
        for (i in 0 until n){
            if(!visited[i]){
                cnt++
                q.offer(i)
                visited[i] = true

                while (!q.isEmpty()){
                    var now: Int = q.poll()
                    for (j in 0 until n){
                        if(j!=now && !visited[j] && computers[now][j]==1)
                        {
                            visited[j] = true
                            q.offer(j)
                        }
                    }
                }
            }
        }

        return cnt
    }
}

fun main(args: Array<String>){
    println(Solution().solution(3, arrayOf(intArrayOf(1,1,0), intArrayOf(1,1,0), intArrayOf(0,0,1))))
}