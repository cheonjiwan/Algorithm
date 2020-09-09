import heapq

INF = 987654321

n,m,k = map(int,input().split())
graph = [[] for _ in range(n+1)]
distance = [[INF] for _ in range(k+1)]

for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a].append((b,c))

def dijkstra(start):
    q=[]
    heapq.heappush(q,(0,start))
    distance[start][start] = 0
    while q:
        dist, now = heapq.heappop(q)

        for i in graph[now]:
            cost = dist+i[1]
            if(len(distance[i[0]]) <k):
                heapq.heappush(distance[i[0]],(-cost,i[0]))
            elif(len(distance[i[0]]) == k):
                heapq.heappush(min(heapq.heappop(distance[i[0]],cost)))
                


            if cost < heapq.heappop(distance[i[0]]):
                heapq.heappush(distance[i[0]],(-cost,i[0]))
                heapq.heappush(q,(cost,i[0]))
            if(len(distance[i[0]]) < k):
                
                heapq.heappush(distance[i[0]],(cost,i[0]))
            elif(len(distance[i[0]])==k):
                
                

for i in range(k):
    dijkstra(1)

print(distance)
