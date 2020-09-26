import sys
from collections import deque
input = sys.stdin.readline

dx = [-1,0,1,0]
dy = [0,-1,0,1]

n,l,r = map(int,input().rstrip().split())
data=[]
for _ in range(n):
    data.append(list(map(int,input().rstrip().split())))

def bfs(x,y,index):
    united = []
    united.append((x,y))
    q = deque([(x,y)])
    union[x][y] = index
    people = data[x][y]
    count=1
    
    while q:
        x,y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if 0<=nx<n and 0<=ny<n and union[nx][ny]==-1:
                if l <=abs(data[x][y]-data[nx][ny]) <= r:
                    union[nx][ny] = index
                    q.append((nx,ny))
                    people+=data[nx][ny]
                    count+=1
                    united.append((nx,ny))
    for i,j in united:
        data[i][j] = people//count


total = 0
while True:
    union = [[-1]*n for _ in range(n)]
    index = 0
    for i in range(n):
        for j in range(n):
            if union[i][j]==-1:
                bfs(i,j,index)
                index+=1
    if index == n*n:
        break
    total+=1

print(total)