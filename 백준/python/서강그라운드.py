from heapq import heappush,heappop
from copy import deepcopy

input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n,m,r=MIS()
items=[0]+list(MIS())
graph=[[] for _ in range(n+1)]
for _ in range(r):
    a,b,c=MIS()
    graph[a].append((b,c))
    graph[b].append((a,c))

INF=2e10
def dijkstra(start):
    item=deepcopy(items)
    distance=[INF]*(n+1)
    q=[]
    distance[start]=0
    heappush(q,(0,start))
    getItem=0
    while q:
        dist,now=heappop(q)
        getItem+=item[now]
        item[now]=0
        for nextNode,nextDist in graph[now]:
            cost=dist+nextDist
            if cost<=m and distance[nextNode]>cost:
                distance[nextNode]=cost
                heappush(q,(cost,nextNode))
    return getItem

result=0
for i in range(1,n+1):
    result=max(result,dijkstra(i))
print(result)
