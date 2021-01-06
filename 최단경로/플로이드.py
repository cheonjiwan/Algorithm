input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n=int(input().rstrip());m=int(input().rstrip())
INF=2e10
graph=[[INF for _ in range(n+1)] for _ in range(n+1)]

for _ in range(m):
    a,b,c=MIS()
    if graph[a][b]>c: graph[a][b]=c

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if i==j: graph[i][j]=0
            else: graph[i][j]=min(graph[i][j],graph[i][k]+graph[k][j])

for i in range(1,n+1):
    for j in range(1,n+1):
        if graph[i][j]==INF: print(0,end=' ')
        else: print(graph[i][j],end=' ')
    print()