class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        var list = ArrayList<Data>()
        var len = jobs.size

        for (job in jobs) {
            list.add(Data(job[0], job[1]))
        }

        list.sort()

        var time=0
        var total=0
        while(list.size>0){
            for (i in 0 until list.size){
                if(time>=list[i].start){
                    time+=list[i].cost
                    total+=time-list[i].start
                    list.removeAt(i)
                    break
                }
                if(i==list.size-1)
                    time++
            }
        }

        return total/len
    }
}

data class Data(var start: Int, var cost: Int): Comparable<Data>{
    override fun compareTo(other: Data): Int{
        if(cost == other.cost){
            return start-other.start
        }
        return cost-other.cost
    }
}

fun main(args: Array<String>){

}