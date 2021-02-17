import sys,heapq
input = sys.stdin.readline

dx = [-1,0,1,0]
dy = [0,-1,0,1]

INF = 987654321
n = int(input().rstrip())
board = []
distance = eval(("[[INF]*n]+" * n)[:-1])
for _ in range(n):
    board.append(list(map(int,input().rstrip())))

def dijkstra(s_x,s_y):
    q = []
    heapq.heappush(q,(0,(s_x,s_y)))
    distance[s_x][s_y] = 0

    while q :
        dist, now = heapq.heappop(q)
        
        if distance[now[0]][now[1]] < dist:
            continue

        for i in range(4):
            nx = now[0] + dx[i]
            ny = now[1] + dy[i]
            if 0<=nx<n and 0<=ny<n:
                if distance[nx][ny]!=INF:
                    continue
                if board[nx][ny]==1:
                    distance[nx][ny]=distance[now[0]][now[1]]
                    heapq.heappush(q,(0,(nx,ny)))
                else:
                    cost = distance[now[0]][now[1]]+1
                    # if distance[nx][ny]==0:
                    #     distance[nx][ny]=cost
                    if cost < distance[nx][ny]:
                        distance[nx][ny] = cost
                        heapq.heappush(q,(cost,(nx,ny)))
    
    return distance[n-1][n-1]

print(dijkstra(0,0))
