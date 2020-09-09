import sys, heapq

input = sys.stdin.readline


def dijkstra(start, end):
    q = []
    heapq.heappush(q, (0, start))
    distance[start].append(0)
    while q:
        dist, now = heapq.heappop(q)

        for i in graph[now]:
            cost = dist + i[1]
            if len(distance[i[0]]) < 2:
                heapq.heappush(distance[i[0]], -cost)
                heapq.heappush(q, (cost, i[0]))
            elif len(distance[i[0]]) == 2:
                a = heapq.heappop(distance[i[0]])
                if -cost > a:
                    heapq.heappush(distance[i[0]], -cost)
                    heapq.heappush(q, (cost, i[0]))
                else:
                    heapq.heappush(distance[i[0]], a)

    if len(distance[end]) < 2:
        print(-1)
    else:
        print(-distance[end][0])


while True:
    n, m = map(int, input().split())
    if n == 0 and m == 0:
        break
    graph = [[] for _ in range(n)]
    distance = [[] for _ in range(n)]

    s, d = map(int, input().split())
    for _ in range(m):
        a, b, c = map(int, input().split())
        graph[a].append((b, c))

    dijkstra(s, d)
