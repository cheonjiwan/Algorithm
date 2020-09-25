import sys,copy
from collections import deque
input = sys.stdin.readline

data = []
virus = []
dx = [-1,0,1,0]
dy = [0,-1,0,1]

n,k = map(int,input().rstrip().split())
for i in range(n):
    row = list(map(int,input().rstrip().split()))
    data.append(row)
    for j in range(n):
        if row[j]!=0:
            virus.append((i,j,row[j]))
s,s_x,s_y = map(int,input().rstrip().split())


for _ in range(s):
    copy_virus = copy.deepcopy(virus)
    q = deque(copy_virus)
    while q:
        x,y,num = q.popleft()
        for i in range(4):
            nx = x+dx[i]
            ny = y+dy[i]
            if nx>=0 and nx<n and ny>=0 and ny<n:
                if data[nx][ny]==0:
                    data[nx][ny]=num
                    virus.append((nx,ny,num))
    

print(data[s_x-1][s_y-1])