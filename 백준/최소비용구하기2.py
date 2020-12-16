import heapq
input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n=int(input().rstrip());m=int(input().rstrip())
graph=[[] for _ in range(n+1)];INF=2e10;distance=[INF]*(n+1)
trace=[0 for _ in range(n+1)]
for _ in range(m):
    a,b,c=MIS();graph[a].append((b,c))
start,end=MIS()

def dijkstra(start):
    q=[]
    heapq.heappush(q,(start,0));distance[start]=0
    while q:
        now,dist=heapq.heappop(q)
        if dist>distance[now]:
            continue
        for i in graph[now]:
            cost=dist+i[1]
            if cost<distance[i[0]]:
                distance[i[0]]=cost
                trace[i[0]]=now
                heapq.heappush(q,(i[0],cost))

dijkstra(start)
print(distance[end])
path=[end]
tmp=trace[end]
while tmp!=0:
    path.append(tmp)
    tmp=trace[tmp]
print(len(path))
for i in range(len(path)-1,-1,-1):
    print(path[i],end=' ')