from collections import deque

input=__import__('sys').stdin.readline
M=lambda:map(str,input().rstrip())
l,w=map(int,input().rstrip().split())
board=[]
for _ in range(l):
    board.append(list(M()))

def bfs(i,j):
    dx=[-1,0,1,0];dy=[0,-1,0,1]
    q=deque();q.append((i,j))
    visited=[[False for _ in range(w)] for _ in range(l)]
    tmp=[[0 for _ in range(w)] for _ in range(l)]
    visited[i][j]=True
    result=0
    while q:
        x,y=q.popleft()
        for idx in range(4):
            nx,ny=x+dx[idx],y+dy[idx]
            if 0<=nx<l and 0<=ny<w and not visited[nx][ny] and board[nx][ny]=='L':
                visited[nx][ny]=True
                tmp[nx][ny]=tmp[x][y]+1
                result=max(result,tmp[nx][ny])
                q.append((nx,ny))

    return result

result=0
for i in range(len(board)):
    for j in range(len(board[i])):
        if board[i][j]=='L':
            result=max(result,bfs(i,j))
print(result)