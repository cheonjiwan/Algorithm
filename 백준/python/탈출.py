from collections import deque
import sys
input = sys.stdin.readline

dx = [-1,0,1,0]
dy = [0,-1,0,1]
r, c = map(int,input().rstrip().split())
board = []
result = 0
for _ in range(r):
    board.append(list(map(str,input().rstrip())))
visited = [[0]*c for _ in range(r)]

water_q = deque()
quokka_q = deque()
                    
def bfs(x,y):
    visited[x][y] = 0
    quokka_q.append((x,y))

    while quokka_q : 
        for i in range(len(water_q)):
            w_x, w_y = water_q.popleft()
            for i in range(4):
                wnx = w_x + dx[i]
                wny = w_y + dy[i]
                if 0<=wnx<r and 0<=wny<c:
                    if board[wnx][wny]=='.':
                        water_q.append((wnx,wny))
                        board[wnx][wny] = '*'
        for i in range(len(quokka_q)):
            q_x, q_y = quokka_q.popleft()
            for i in range(4):
                qnx = q_x + dx[i]
                qny = q_y + dy[i]
                if 0<=qnx<r and 0<=qny<c:
                    if board[qnx][qny] == 'D':
                        return visited[q_x][q_y]+1
                    if visited[qnx][qny]:
                        continue
                    if board[qnx][qny]=='.':
                        quokka_q.append((qnx,qny))
                        visited[qnx][qny] = visited[q_x][q_y]+1

    return 'KAKTUS'

for i in range(r):
    for j in range(c):
        if board[i][j] == 'S':
            x, y = i,j
        if board[i][j] == '*':
            water_q.append((i,j))
board[x][y] = '.'

print(bfs(x,y))
