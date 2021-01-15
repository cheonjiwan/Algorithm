from collections import deque

input=__import__('sys').stdin.readline
MIS=lambda:map(str,input().rstrip())
n=int(input().rstrip());board=[]
for _ in range(n):
    board.append(list(MIS()))

visited=[[False for _ in range(n)] for _ in range(n)]
r,g,b=0,0,0
dx=[-1,0,1,0];dy=[0,-1,0,1]
q=deque()
for i in range(len(board)):
    for j in range(len(board[i])):
        if board[i][j]=='R' and not visited[i][j]:
            r+=1
            visited[i][j]=True
            q.append((i,j))
            while q:
                x,y=q.popleft()
                for idx in range(4):
                    nx,ny=x+dx[idx],y+dy[idx]
                    if 0<=nx<n and 0<=ny<n and board[nx][ny]=='R' and not visited[nx][ny]:
                        visited[nx][ny]=True
                        q.append((nx,ny))
        elif board[i][j]=='G' and not visited[i][j]:
            g+=1
            visited[i][j]=True
            q.append((i,j))
            while q:
                x,y=q.popleft()
                for idx in range(4):
                    nx,ny=x+dx[idx],y+dy[idx]
                    if 0<=nx<n and 0<=ny<n and board[nx][ny]=='G' and not visited[nx][ny]:
                        visited[nx][ny]=True
                        q.append((nx,ny))
        elif board[i][j]=='B' and not visited[i][j]:
            b+=1
            visited[i][j]=True
            q.append((i,j))
            while q:
                x,y=q.popleft()
                for idx in range(4):
                    nx,ny=x+dx[idx],y+dy[idx]
                    if 0<=nx<n and 0<=ny<n and board[nx][ny]=='B' and not visited[nx][ny]:
                        visited[nx][ny]=True
                        q.append((nx,ny))

r_g,b=0,0
q2=deque()
visited=[[False for _ in range(n)] for _ in range(n)]
for i in range(len(board)):
    for j in range(len(board[i])):
        if (board[i][j]=='R' or board[i][j]=='G') and not visited[i][j]:
            r_g+=1
            visited[i][j]=True
            q2.append((i,j))
            while q2:
                x,y=q2.popleft()
                for idx in range(4):
                    nx,ny=x+dx[idx],y+dy[idx]
                    if 0<=nx<n and 0<=ny<n and (board[nx][ny]=='R' or board[nx][ny]=='G') and not visited[nx][ny]:
                        visited[nx][ny]=True
                        q2.append((nx,ny))
        elif board[i][j]=='B' and not visited[i][j]:
            b+=1
            visited[i][j]=True
            q2.append((i,j))
            while q2:
                x,y=q2.popleft()
                for idx in range(4):
                    nx,ny=x+dx[idx],y+dy[idx]
                    if 0<=nx<n and 0<=ny<n and board[nx][ny]=='B' and not visited[nx][ny]:
                        visited[nx][ny]=True
                        q2.append((nx,ny))
print(r+g+b,r_g+b)