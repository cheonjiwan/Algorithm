from collections import deque

n,k=map(int,input().split())
dx=[-1,1,2]
visited=[[-1,0] for _ in range(100001)]
visited[n][0]=0
visited[n][1]=1
q=deque();q.append(n)
while q:
    now=q.popleft()
    for i in range(3):
        if i==2: nx=now*dx[i]
        else: nx=now+dx[i]
        
        if 0<=nx<100001:
            if visited[nx][0]==-1:
                visited[nx][0]=visited[now][0]+1
                visited[nx][1]=visited[now][1]
                q.append(nx)
            elif visited[nx][0]==visited[now][0]+1:
                visited[nx][1]+=visited[now][1]
                
print(visited[k][0])
print(visited[k][1])