import sys
from collections import deque
input = sys.stdin.readline

n,l,r = map(int,input().rstrip().split())
data = []
dx = [-1,0,1,0]
dy = [0,-1,0,1]

for _ in range(n):
    data.append(list(map(int,input().rstrip().split())))

def bfs(x,y,group):
    check[x][y]=True
    people = data[x][y]
    count=1
    united = []
    united.append((x,y))
    q = deque([(x,y)])
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]    
            if 0<=nx<n and 0<=ny<n and not check[nx][ny]:
                if l<=abs(data[x][y]-data[nx][ny])<=r:
                    q.append((nx,ny))
                    check[nx][ny]=True
                    people+=data[nx][ny]
                    count+=1
                    united.append((nx,ny))
    for country in united:
        data[country[0]][country[1]] = people//count
    
total = 0
while True:
    check = [[False]*n for _ in range(n)]
    group = 0
    
    for i in range(n):
        for j in range(n):
            if not check[i][j]:
                bfs(i,j,group)
                group+=1

    if group==n*n:
        break
    total+=1

print(total)