import sys, copy
from collections import deque

input = sys.stdin.readline

dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]
INF = 987654321

n, m, fuel = map(int, input().split())
space = []
peoples = []
mydic = {}

start_list = []
end_list = []

for _ in range(n):
    space.append(list(map(int, input().split())))

first_x, first_y = map(int, input().split())
first_x -= 1
first_y -= 1


def bfs1(now_x, now_y):
    dist = [[-1] * (n) for _ in range(n)]
    dist[now_x][now_y] = 0
    q = deque([(now_x, now_y)])

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and nx < n and ny >= 0 and ny < n:
                if dist[nx][ny] == -1 and space[nx][ny] != 1:
                    dist[nx][ny] = dist[x][y] + 1
                    q.append((nx, ny))

    return dist


def bfs2(now_x, now_y):
    return_x, return_y = mydic[(now_x, now_y)]
    dist = [[-1] * (n) for _ in range(n)]
    dist[now_x][now_y] = 0
    q = deque([(now_x, now_y)])

    while q:
        x, y = q.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and nx < n and ny >= 0 and ny < n:
                if dist[nx][ny] == -1 and space[nx][ny] != 1:
                    dist[nx][ny] = dist[x][y] + 1
                    q.append((nx, ny))

    return dist, (return_x, return_y)


def find_people(dist):
    x, y = 0, 0
    min_dist = INF
    result = []
    for i in range(n):
        for j in range(n):
            if dist[i][j] != -1 and dist[i][j] <= min_dist and space[i][j] == "a":
                min_dist = dist[i][j]
                result.append([min_dist, i, j])

    if min_dist == INF:
        return -1
    else:
        result = sorted(result, key=lambda x: (x[0], x[1], x[2]))

    return result[0][0], result[0][1], result[0][2]


def find_des(dist, where_des):
    x, y = 0, 0
    min_dist = INF
    result = []
    for i in range(n):
        for j in range(n):
            if dist[i][j] != -1 and dist[i][j] <= min_dist and space[i][j] == "b":
                min_dist = dist[i][j]
                # result.append([min_dist, i, j])

    min_dist = dist[where_des[0]][where_des[1]]

    if min_dist == INF:
        return -1
    else:
        return min_dist

    # return result[0][0], result[0][1], result[0][2]
    # return min_dist


for i in range(1, m + 1):
    start_x, start_y, end_x, end_y = map(int, input().split())
    start_list.append((start_x - 1, start_y - 1))
    end_list.append((end_x - 1, end_y - 1))
    mydic[(start_x - 1, start_y - 1)] = (end_x - 1, end_y - 1)

x, y = first_x, first_y

for _ in range(m):
    for item in start_list:
        space[item[0]][item[1]] = "a"
    value = find_people(bfs1(x, y))
    if value == -1:
        print(-1)
        sys.exit()
    else:
        fuel -= value[0]
        if fuel < 0:
            print(-1)
            sys.exit()
        else:
            x, y = value[1], value[2]
            space[x][y] = 0
            start_list.remove((x, y))

    for item in end_list:
        space[item[0]][item[1]] = "b"
    mymap, where_des = bfs2(x, y)
    value2 = find_des(mymap, where_des)

    if value2 == -1:
        print(-1)
        sys.exit()
    else:
        fuel -= value2
        if fuel < 0:
            print(-1)
            sys.exit()
        else:
            fuel += value2 * 2
            space[where_des[0]][where_des[1]] = 0
            x, y = where_des[0], where_des[1]
            end_list.remove((x, y))

print(fuel)