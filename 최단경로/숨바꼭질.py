import heapq

input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
INF=2e10
n,m=MIS()
graph=[[] for _ in range(n+1)]
for _ in range(m):
    a,b=MIS()
    graph[a].append((b,1));graph[b].append((a,1))

distance=[[INF,i] for i in range(n+1)]
start=1;distance[start][0]=0
q=[];heapq.heappush(q,(0,start))
while q:
    dist,now=heapq.heappop(q)
    if dist>distance[now][0]: continue

    for next_,cost in graph[now]:
        new_cost=dist+cost
        if new_cost<distance[next_][0]:
            distance[next_][0]=new_cost
            heapq.heappush(q,(new_cost,next_))

distance=sorted(distance,key=lambda x: (-x[0],x[1]))
result_node,result_dist=distance[1][1],distance[1][0]
cnt=1
for i in range(2,n+1):
    if distance[i][0]==result_dist: cnt+=1
print(result_node,result_dist,cnt)



