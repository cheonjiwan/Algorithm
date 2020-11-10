import heapq
input=__import__('sys').stdin.readline
M=lambda:map(int,input().split())
n,m = M();graph=[[] for _ in range(n+1)];indegree=[0]*(n+1)
q=[];result=[]
for _ in range(m):
    a,b = M();graph[a].append(b);indegree[b]+=1
for i in range(1,n+1):
    if indegree[i]==0:q.append(i)
while q:
    now=heapq.heappop(q);result.append(now)
    for i in graph[now]:
        indegree[i]-=1
        if indegree[i]==0:heapq.heappush(q,i)
print(" ".join(str(i) for i in result))