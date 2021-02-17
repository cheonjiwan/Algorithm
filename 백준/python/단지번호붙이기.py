from collections import deque

input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip())
n=int(input().rstrip());board=[]
for _ in range(n):
    board.append(list(MIS()))

dx=[-1,0,1,0];dy=[0,-1,0,1]
visited=[[False for _ in range(n)] for _ in range(n)]
q=deque();danji=0
result=[]
for i in range(len(board)):
    for j in range(len(board[i])):
        if board[i][j]==1 and not visited[i][j]:
            danji+=1
            cnt=1
            q.append((i,j));visited[i][j]=True
            while q:
                x,y=q.popleft()
                for idx in range(4):
                    nx,ny=x+dx[idx],y+dy[idx]
                    if 0<=nx<n and 0<=ny<n and board[nx][ny]==1 and not visited[nx][ny]:
                        cnt+=1
                        visited[nx][ny]=True
                        q.append((nx,ny))
            result.append((danji,cnt)) 

print(len(result))
result=sorted(result,key=lambda x: x[1])
for danji,cnt in result:
    print(cnt)