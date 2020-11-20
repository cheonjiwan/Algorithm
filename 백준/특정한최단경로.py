import sys,heapq
input=sys.stdin.readline
n,e=map(int,input().rstrip().split())
graph=[[] for _ in range(n+1)];INF=2e10
for _ in range(e):
    a,b,c=map(int,input().rstrip().split())
    graph[a].append((b,c));graph[b].append((a,c))
s1,s2=map(int,input().rstrip().split())

def dijkstra(start):
    distance=[INF]*(n+1)
    distance[start]=0;q=[]
    heapq.heappush(q,(0,start))
    while q:
        dist,now=heapq.heappop(q)
        if dist<distance[now]:continue
        for i in graph[now]:
            cost=dist+i[1]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                heapq.heappush(q,(cost,i[0]))
    return distance

first=dijkstra(1)
second1=dijkstra(s1);second2=dijkstra(s2)
result=min(first[s1]+second1[s2]+second2[n],first[s2]+second2[s1]+second1[n])
print(-1 if result>=INF else result)