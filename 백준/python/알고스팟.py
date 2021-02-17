from collections import deque
input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
m,n=MIS();board=[]
dx=[-1,0,1,0];dy=[0,-1,0,1]
for _ in range(n):
    board.append(list(map(int,input().rstrip())))
visited=[[False for _ in range(m)] for _ in range(n)]
q=deque([(0,0)]);visited[0][0]=True
while q:
    x,y=q.popleft()
    for i in range(4):
        nx,ny=x+dx[i],y+dy[i]
        if 0<=nx<n and 0<=ny<m and not visited[nx][ny]:
            if board[nx][ny]==1:
                board[nx][ny]=board[x][y]+1
                q.append((nx,ny))
                visited[nx][ny]=True
            else:
                board[nx][ny]=board[x][y]
                q.appendleft((nx,ny))
                visited[nx][ny]=True
print(board[n-1][m-1])