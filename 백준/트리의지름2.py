from collections import deque
import sys
input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n=int(input().rstrip())
graph=[[] for _ in range(n+1)]
for _ in range(n-1):
    a,b,c=MIS()
    graph[a].append((b,c))
    graph[b].append((a,c))

def bfs(start):
    q=deque()
    q.append((start,0))
    visited=[False]*(n+1); visited[start]=True

    maxDist=0
    maxNode=0
    while q:
        now,cost=q.popleft()
        for nextNode,nextCost in graph[now]:
            if not visited[nextNode]:
                visited[nextNode]=True
                if cost+nextCost>maxDist:
                    maxDist=cost+nextCost
                    maxNode=nextNode
                q.append((nextNode,cost+nextCost))
    return maxNode,maxDist

node,dist=bfs(1)
print(bfs(node)[1])
