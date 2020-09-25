import sys,copy
from collections import deque
from itertools import combinations

input = sys.stdin.readline

board = []
virus = []
other = []

dx = [-1,0,1,0]
dy = [0,-1,0,1]

n,m = map(int,input().rstrip().split())
for i in range(n):
    row = list(map(int,input().rstrip().split()))
    board.append(row)
    for j in range(m):
        if row[j]==2:
            virus.append((i,j))
        elif row[j]==0:
            other.append((i,j))

def bfs(temp):
    q = deque(virus)
    while q:
        x , y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx>=0 and nx<n and ny>=0 and ny<m:
                if temp[nx][ny]==0:
                    temp[nx][ny]=2
                    q.append((nx,ny))

def solution():
    result = 0
    score=0
    combs = list(combinations(other,3))
    for comb in combs:
        temp = copy.deepcopy(board)
        for x,y in comb:
            temp[x][y] = 1
        bfs(temp)
        for i in range(n):
            for j in range(m):
                if temp[i][j]==0:
                    score+=1
        result = max(result,score)
        score=0
    
    return result

print(solution())

