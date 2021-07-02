import java.util.*;
import java.io.*;
import kotlin.collections.ArrayList

lateinit var graph: ArrayList<ArrayList<Node>>
lateinit var distance: IntArray
lateinit var pq : PriorityQueue<Node>

data class Node(var v: Int, var cost: Int) : Comparable<Node>{
    override fun compareTo(other: Node): Int = cost - other.cost
}

fun main(args: Array<String>){
    var br = BufferedReader(InputStreamReader(System.`in`))
    var st = StringTokenizer(br.readLine())

    var v = st.nextToken().toInt()
    var e = st.nextToken().toInt()

    graph = ArrayList()
    for (i in 0 until v) graph.add(ArrayList())

    distance = IntArray(v){987654321}

    var start = Integer.parseInt(br.readLine())-1
    for (i in 0 until e){
        st = StringTokenizer(br.readLine())
        var u = Integer.parseInt(st.nextToken())-1
        var v = Integer.parseInt(st.nextToken())-1
        var w = Integer.parseInt(st.nextToken())
        graph[u].add(Node(v,w))
    }

    dijkstra(start)
    var sb = StringBuilder()
    distance.forEach {
        if(it == 987654321){
            sb.append("INF").append('\n')
        }
        else
            sb.append(it).append('\n')
    }
    print(sb.toString())
}

fun dijkstra(start : Int){
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
}