import heapq

input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
t=int(input().rstrip())
dx=[-1,0,1,0];dy=[0,-1,0,1];INF=2e10

for _ in range(t):
    n=int(input().rstrip())
    board=[]
    for _ in range(n):
        board.append(list(MIS()))
    distance=[[INF for _ in range(n)] for _ in range(n)]
    q=[];s_x,s_y=0,0
    heapq.heappush(q,(board[s_x][s_y],s_x,s_y));distance[s_x][s_y]=board[s_x][s_y]

    while q:
        dist,x,y=heapq.heappop(q)
        if dist>distance[x][y]: continue

        for i in range(4):
            nx,ny=x+dx[i],y+dy[i]
            if 0<=nx<n and 0<=ny<n:
                cost=dist+board[nx][ny]
                if cost<distance[nx][ny]:
                    distance[nx][ny]=cost
                    heapq.heappush(q,(cost,nx,ny))
    print(distance[n-1][n-1])

