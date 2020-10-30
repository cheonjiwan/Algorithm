from collections import deque
import sys

input = sys.stdin.readline

n = int(input())

INF = 987654321
space = []
now_size = 2
now_x, now_y = 0,0

for i in range(n):
    space.append(list(map(int,input().split())))

for i in range(n):
    for j in range(n):
        if space[i][j]==9:
            now_x = i
            now_y = j
            space[i][j]=0

dx = [-1,0,1,0]
dy = [0,-1,0,1]

def bfs():
    dist = [[-1]*(n) for _ in range(n)]
    dist[now_x][now_y] = 0
    q = deque([(now_x,now_y)])
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx>=0 and nx<n and ny>=0 and ny<n:
                # 지나갈 수 있다면
                if dist[nx][ny] == -1 and space[nx][ny]<=now_size:
                    dist[nx][ny] = dist[x][y]+1
                    q.append((nx,ny))

    return dist

def find(dist):
    x,y = 0,0
    min_dist = INF
    for i in range(n):
        for j in range(n):
            # 먹을 수 있다면
            if dist[i][j] != -1 and 1<=space[i][j]<now_size:
                if dist[i][j] < min_dist:
                    min_dist = dist[i][j]   
                    x,y = i,j

    if min_dist == INF:
        return None
    else:
        return x,y,min_dist

result = 0
eat = 0

while True:
    value = find(bfs())

    if value==None:
        print(result)
        break
    else:
        now_x, now_y = value[0],value[1]
        result += value[2]

        space[now_x][now_y] = 0
        eat+=1
        if eat==now_size:
            now_size+=1
            eat=0

