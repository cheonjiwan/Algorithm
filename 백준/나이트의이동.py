from collections import deque
input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())

def bfs(s_x,s_y,e_x,e_y):
    dx=[-2,-1,1,2,2,1,-1,-2]
    dy=[-1,-2,-2,-1,1,2,2,1]
    q=deque();q.append((s_x,s_y))
    visited=[[0 for _ in range(l)] for _ in range(l)]
    while q:
        x,y=q.popleft()
        if x==e_x and y==e_y:
            return visited[e_x][e_y]

        for i in range(8):
            nx,ny=x+dx[i],y+dy[i]
            if 0<=nx<l and 0<=ny<l and not visited[nx][ny]:
                visited[nx][ny]=visited[x][y]+1
                q.append((nx,ny))

t=int(input().rstrip())
for _ in range(t):
    l=int(input().rstrip())
    s_x,s_y=MIS();e_x,e_y=MIS()
    print(bfs(s_x,s_y,e_x,e_y))