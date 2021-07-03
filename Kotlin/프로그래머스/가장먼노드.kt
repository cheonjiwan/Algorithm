import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

data class Node(var v: Int, var cost : Int) : Comparable<Node>{
    override fun compareTo(other: Node): Int = cost-other.cost
}

class Solution {
    lateinit var graph : ArrayList<ArrayList<Node>>
    lateinit var distance: IntArray
    lateinit var pq: PriorityQueue<Node>

    fun solution(n: Int, edge: Array<IntArray>): Int {
        var answer = 0

        distance = IntArray(n+1){987654321}

        graph = ArrayList(n)
        for (i in 0..n)
            graph.add(ArrayList())

        for (array in edge){
            graph[array[0]].add(Node(array[1],1))
            graph[array[1]].add(Node(array[0],1))
        }
        return dijkstra(1)
    }

    fun dijkstra(start: Int): Int{
        distance[start] = 0
        pq = PriorityQueue<Node>()
        pq.offer(Node(start,0))

        while(pq.isNotEmpty()){
            var cur = pq.poll()
            var now = cur.v
            var dist = cur.cost
            if(distance[now] < dist)
                continue

            for (next in graph[now]){
                var cost = dist + next.cost
                if(distance[next.v] > cost)
                {
                    distance[next.v] = cost
                    pq.offer(Node(next.v,cost))
                }
            }
        }

        var maxValue = Int.MIN_VALUE
        for (i in 1 until distance.size){
            maxValue = max(maxValue,distance[i])
        }

        var answer = 0
        for (i in 1 until distance.size){
            if(maxValue == distance[i])
                answer++
        }

        return answer
    }
}

fun main(args: Array<String>){
    println(Solution().solution(6, arrayOf(intArrayOf(3,6),intArrayOf(4,3),intArrayOf(3,2),intArrayOf(1,3),intArrayOf(1,2),intArrayOf(2,4),intArrayOf(5,2))))
}