from collections import deque
n,m=map(int,input().rstrip().split())
second=0
visited=[0]*100001
q=deque();q.append(n)
dx=[-1,1,2]
while q:
    now=q.popleft()
    if now==m: print(visited[m]);break
    for idx in range(3):
        if idx==2: nx=now*dx[idx]
        else: nx=now+dx[idx]
        if 0<=nx<=100000 and not visited[nx]:
            visited[nx]=visited[now]+1
            q.append(nx)