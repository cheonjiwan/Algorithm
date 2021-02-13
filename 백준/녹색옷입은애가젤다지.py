from heapq import heappush,heappop
import sys
input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())

dx=[-1,0,1,0]
dy=[0,-1,0,1]
t=1
while True:
    n=int(input().rstrip())
    if n==0:
        break
    board=[]
    for _ in range(n):
        board.append(list(MIS()))
    
    visited=[[False for _ in range(n)] for _ in range(n)]
    q=[]
    start=(0,0)
    heappush(q,(board[0][0],start))
    visited[0][0]=True
    while q:
        dist,now=heappop(q)
        x,y=now
        if x==n-1 and y==n-1:
            print('Problem {}:'.format(t),end=' ')
            print(dist)
            break
        for i in range(4):
            nx,ny=x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n and not visited[nx][ny]:
                cost=dist+board[nx][ny]
                nextpos=(nx,ny)
                visited[nx][ny]=True
                heappush(q,(cost,nextpos))
    t+=1
