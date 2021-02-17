from collections import deque

input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
t=int(input().rstrip())
dx=[-1,0,1,0];dy=[0,-1,0,1]
for _ in range(t):
    m,n,k=MIS()
    board=[[0 for _ in range(m)] for _ in range(n)]
    for _ in range(k):
        j,i=MIS()
        board[i][j]=1
    visited=[[False for _ in range(m)] for _ in range(n)]
    q=deque();cnt=0
    for i in range(n):
        for j in range(m):
            if board[i][j]==1 and not visited[i][j]:
                visited[i][j]=True
                q.append((i,j));cnt+=1
                while q:
                    x,y=q.popleft()
                    for idx in range(4):
                        nx,ny=x+dx[idx],y+dy[idx]
                        if 0<=nx<n and 0<=ny<m and board[nx][ny]==1 and not visited[nx][ny]:
                            visited[nx][ny]=True
                            q.append((nx,ny))
    print(cnt)