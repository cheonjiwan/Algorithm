from collections import deque

INF = 987654321
board = [[0, 0, 1, 0], [0, 0, 0, 0], [0, 1, 0, 1], [1, 0, 0, 0]]
dx = [-1, 0, 1, 0]
dy = [0, -1, 0, 1]


def bfs(start, n, board, answer):
    now_x, now_y = start[0], start[1]
    q = deque([(now_x, now_y, 0, 9)])
    board[now_x][now_y] = 1

    while q:
        x, y, cost, direction = q.popleft()
        if x == n - 1 and y == n - 1:
            answer = min(answer, board[x][y])
            continue

        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and nx < n and ny >= 0 and ny < n and board[nx][ny] != 1:
                new_cost = 0
                if direction == 9 or direction == i:
                    new_cost = cost + 100
                elif direction != i:
                    new_cost = cost + 600

                if board[nx][ny] == 0:
                    board[nx][ny] = new_cost
                    q.append((nx, ny, new_cost, i))
                elif board[nx][ny] >= new_cost:
                    board[nx][ny] = new_cost
                    q.append((nx, ny, new_cost, i))

    return answer


def solution(board):
    n = len(board)
    answer = INF
    start = (0, 0)
    answer = bfs(start, n, board, answer)

    return answer


result = solution(board)
print(result)