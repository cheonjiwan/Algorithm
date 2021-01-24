import sys
sys.setrecursionlimit(10**5)
input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n=int(input().rstrip());graph=[[] for _ in range(n+1)]

for _ in range(n-1):
    a,b=MIS()
    graph[a].append(b);graph[b].append(a)

colorCost=[i for i in range(17)]
dp=[[0]*17 for _ in range(n+1)]
visited=[False]*(n+1)
def dfs(start):
    for nextNode in graph[start]:
        if not visited[nextNode]:
            visited[nextNode]=True
            dfs(nextNode)
            for i in range(1,17):
                minV=2e10
                for j in range(1,17):
                    if i!=j:
                        minV=min(minV,dp[nextNode][j])
                dp[start][i]+=minV
    for i in range(1,17):
        dp[start][i]+=i
visited[1]=True
dfs(1)
print(min(dp[1][1:]))
