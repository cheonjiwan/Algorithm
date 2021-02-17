import sys
input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n,k=MIS()
graph=[[0 for _ in range(n+1)] for _ in range(n+1)]
for _ in range(k):
    a,b=MIS()
    graph[a][b]=-1
    graph[b][a]=1

for k in range(1,n+1):
    for i in range(1,n+1):
        for j in range(1,n+1):
            if graph[i][j]==0:
                if graph[i][k]==1 and graph[k][j]==1:
                    graph[i][j]=1
                elif graph[i][k]==-1 and graph[k][j]==-1:
                    graph[i][j]=-1

s=int(input().rstrip())
for _ in range(s):
    a,b=MIS()
    print(graph[a][b])