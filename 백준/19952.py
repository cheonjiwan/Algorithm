import sys,heapq
from collections import deque
input = sys.stdin.readline

INF = 987654321
dx = [-1,0,1,0]
dy = [0,-1,0,1]

t = int(input().rstrip())

def dijkstra(s_x,s_y):
    q = []
    distance[s_x][s_y]=0
    heapq.heappush(q,(0,(s_x,s_y),f))
    power = 0
    while q:
        dist, now, F = heapq.heappop(q)

        if distance[now[0]][now[1]] < dist:
            continue

        for i in range(4):
            power = F
            nx = now[0]+dx[i]
            ny = now[1]+dy[i]
            if 1<=nx<=h and 1<=ny<=w:
                if board[nx][ny]<=board[now[0]][now[1]]:
                    cost = dist+1
                    if power>=1:
                        power-=1
                    else:
                        distance[nx][ny]=-INF
                    if cost<distance[nx][ny]:
                        distance[nx][ny]=cost
                        heapq.heappush(q,(cost,(nx,ny),power))
                else: # 높이가 더 높다면
                    jump_height = board[nx][ny]-board[now[0]][now[1]]
                    cost = dist+1
                    if power>=jump_height:
                        power-=1
                    else:
                        distance[nx][ny]=-INF
                    if cost<distance[nx][ny]:
                        distance[nx][ny] = cost
                        heapq.heappush(q,(cost,(nx,ny),power))
    return distance[e_x][e_y]

for _ in range(t):
    h,w,o,f,s_x,s_y,e_x,e_y = map(int,input().rstrip().split())
    board = eval(("[[0]*(w+1)]+"*(h+1))[:-1])
    distance = eval(("[[INF]*(w+1)]+"*(h+1))[:-1])
    for _ in range(o):
        x,y,l = map(int,input().rstrip().split())
        board[x][y] = l

    if dijkstra(s_x,s_y)==-INF:
        print("인성 문제있어??")
    else:
        if dijkstra(s_x,s_y) <= f:
            print("잘했어!!")
        else:
            print("인성 문제있어??")    

