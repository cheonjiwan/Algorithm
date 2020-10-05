import sys,copy
from itertools import combinations
from collections import deque

input = sys.stdin.readline

n = int(input().rstrip())
board = []
other = []
teacher = []
dx = [-1,0,1,0]
dy = [0,-1,0,1]
resultList = []
for _ in range(n):
    board.append(list(map(str,input().rstrip().split())))

for i in range(n):
    for j in range(n):
        if board[i][j]=='X':
            other.append((i,j))
        elif board[i][j]=='T':
            teacher.append((i,j))

def bfs(temp):
    result = [True]*4
    q = deque(teacher)
    flag = False
    complete = False
    while q:
        x,y = q.popleft()
        nx = x
        ny = y
        # up
        while True:
            nx,ny = nx-1,y
            if 0<=nx<n and 0<=ny<n:
                if temp[nx][ny]=='O' and flag==False:
                    flag=True
                if temp[nx][ny]=='S':
                    if flag==False:
                        return False
            else:
                break
        nx = x
        ny = y
        flag = False
        complete = False
        # down
        while True:
            nx,ny = nx+1,y
            if 0<=nx<n and 0<=ny<n:
                if temp[nx][ny]=='O' and flag==False:
                    flag=True
                elif temp[nx][ny]=='S':
                    if flag==False:
                        return False
            else:
                break
        nx = x
        ny = y
        flag = False
        complete = False
        # left
        while True:
            nx,ny = x,ny-1
            if 0<=nx<n and 0<=ny<n:
                if temp[nx][ny]=='O' and flag==False:
                    flag=True
                elif temp[nx][ny]=='S':
                    if flag==False:
                        return False
            else:
                break
        nx = x
        ny = y 
        flag = False
        complete = False
        # right
        while True:
            nx,ny = x,ny+1
            if 0<=nx<n and 0<=ny<n:
                if temp[nx][ny]=='O' and flag==False:
                    flag=True
                elif temp[nx][ny]=='S':
                    if flag==False:
                        return False
            else:
                break
        flag=False
        complete = False
    return True

combis = list(combinations(other,3))

for combi in combis:
    temp = copy.deepcopy(board)
    for x,y in combi:
        temp[x][y]='O'
    result = bfs(temp)
    resultList.append(result)

if True in resultList:
    print('YES')
else:
    print('NO')

