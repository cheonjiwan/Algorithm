import sys
MIS=lambda:map(int,input().split())
n,m=MIS();INF=2e10;graph=[[] for _ in range(n+1)]
for _ in range(m):
    a,b,c=MIS();graph[a].append((b,c))

def bellman_ford():
    ans=[INF]*(n+1);ans[1]=0
    for i in range(1,n):
        for j in range(1,n+1):
            for b,c in graph[j]:
                if ans[j]==INF:continue
                if ans[b]>c+ans[j]:ans[b]=c+ans[j]
    for j in range(1,n+1):
        for b,c in graph[j]:
            if ans[j]==INF:continue
            if ans[b]>ans[j]+c:print(-1);sys.exit()
    return ans

result=bellman_ford()
for i in range(2,n+1):
    print(-1 if result[i]==INF else result[i])