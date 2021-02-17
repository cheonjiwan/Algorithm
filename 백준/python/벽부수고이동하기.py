from heapq import heappush,heappop
from collections import deque
input=__import__('sys').stdin.readline
n,m=map(int,input().rstrip().split())
board=[]
for _ in range(n):
    board.append(list(map(int,input().rstrip())))

dx=[-1,0,1,0]
dy=[0,-1,0,1]
def bfs():
    arr=[[[False for _ in range(m)] for _ in range(n)] for _ in range(2)]
    q=[]
    heappush(q,(1,0,0,False))
    while q:
        cost,x,y,flag=heappop(q)
        if x==n-1 and y==m-1: return cost
        for i in range(4):
            nx,ny=x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<m and not arr[flag][nx][ny]:
                if board[nx][ny]==1:
                    if not flag:
                        q.append((cost+1,nx,ny,1))
                        arr[1][nx][ny]=True
                else:
                    q.append((cost+1,nx,ny,flag))
                    arr[flag][nx][ny]=True
    return 2e10
result=bfs()
print(-1) if result==2e10 else print(result)
