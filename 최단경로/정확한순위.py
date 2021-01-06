input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
INF=2e10
n,m=MIS();graph=[[INF for _ in range(n+1)] for _ in range(n+1)]
for _ in range(n):
    a,b=MIS()
    graph[a][b]=1
for i in range(1,n+1):
    graph[i][i]=0

for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b]=min(graph[a][b],graph[a][k]+graph[k][b])

# 플로이드 워셜 알고리즘을 수행해서
# 만약 도달할 수 없는 노드가 있다면 성적비교가 불가능하다는 뜻
result=0
for node in range(1,n+1):
    cnt=0
    for node2 in range(1,n+1):
        if graph[node][node2]!=INF or graph[node2][node]!=INF: cnt+=1
    # 도달가능하다면 cnt를 증가시킨 후
    # cnt가 n과 같다면 모든 사람과 비교가 가능하다는 뜻
    if cnt==n: result+=1
print(result)