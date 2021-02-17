import heapq

INF = 1000001

dx = [-1,0,1,0]
dy = [0,-1,0,1]

n,m,t,d = map(int,input().split(' '))
mountain = []
for _ in range(n):
    mountain.append(list(map(str,input())))

for i in range(n):
    for j in range(m):
        if(ord(mountain[i][j])<=ord('Z') and ord(mountain[i][j])>=ord('A')):
            mountain[i][j] = ord(mountain[i][j])-ord('A')
        else:
            mountain[i][j] = ord(mountain[i][j])-ord('a')+26

distance = [[INF]*m for i in range(n)]
distance2 = [[INF]*m for i in range(n)]

def dijkstra(start):
    q = []
    distance[start[0]][start[1]]= 0
    heapq.heappush(q,(0,start))
    while q:
        dist, now = heapq.heappop(q)

        if(distance[now[0]][now[1]] < dist):
            continue
        
        for i in range(4):
            if(now[0]+dx[i] < n and now[0]+dx[i]>=0 and now[1]+dy[i]>=0 and now[1]+dy[i]<m):
                if(abs(mountain[now[0]][now[1]] - mountain[now[0]+dx[i]][now[1]+dy[i]]) <= t):
                    if(mountain[now[0]][now[1]] >= mountain[now[0]+dx[i]][now[1]+dy[i]]):
                        cost = dist+1
                        if(cost < distance[now[0]+dx[i]][now[1]+dy[i]]):
                            distance[now[0]+dx[i]][now[1]+dy[i]]=cost
                            heapq.heappush(q,(cost,(now[0]+dx[i],now[1]+dy[i])))
                    else:
                        cost = dist+ pow(abs(mountain[now[0]][now[1]] - mountain[now[0]+dx[i]][now[1]+dy[i]]),2)
                        if(cost < distance[now[0]+dx[i]][now[1]+dy[i]]):
                            distance[now[0]+dx[i]][now[1]+dy[i]]=cost
                            heapq.heappush(q,(cost,(now[0]+dx[i],now[1]+dy[i])))

def dijkstra2(start):
    q = []
    distance2[start[0]][start[1]]= 0
    heapq.heappush(q,(0,start))
    while q:
        dist, now = heapq.heappop(q)

        if(distance2[now[0]][now[1]] < dist):
            continue
        
        for i in range(4):
            if(now[0]+dx[i] < n and now[0]+dx[i]>=0 and now[1]+dy[i]>=0 and now[1]+dy[i]<m):
                if(abs(mountain[now[0]][now[1]] - mountain[now[0]+dx[i]][now[1]+dy[i]]) <= t):
                    if(mountain[now[0]][now[1]] <= mountain[now[0]+dx[i]][now[1]+dy[i]]):
                        cost = dist+1
                        if(cost < distance2[now[0]+dx[i]][now[1]+dy[i]]):
                            distance2[now[0]+dx[i]][now[1]+dy[i]]=cost
                            heapq.heappush(q,(cost,(now[0]+dx[i],now[1]+dy[i])))
                    else:
                        cost = dist+ pow(abs(mountain[now[0]][now[1]] - mountain[now[0]+dx[i]][now[1]+dy[i]]),2)
                        if(cost < distance2[now[0]+dx[i]][now[1]+dy[i]]):
                            distance2[now[0]+dx[i]][now[1]+dy[i]]=cost
                            heapq.heappush(q,(cost,(now[0]+dx[i],now[1]+dy[i])))

start = (0,0)
dijkstra(start)
dijkstra2(start)
# print(distance2)
max_v=0
for i in range(n):
    for j in range(m):
        if(distance[i][j]+distance2[i][j]<=d):
            max_v = max(max_v,mountain[i][j])

print(max_v)

