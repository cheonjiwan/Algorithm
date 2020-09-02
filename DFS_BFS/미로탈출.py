from collections import deque

dx = [-1,0,1,0]
dy = [0,-1,0,1]

n,m = map(int,input().split())
maze = []
    
for i in range(n):
    maze.append(list(map(int,input())))

def bfs(x,y):
    queue = deque()
    queue.append((x,y))
    
    while queue:
        data = queue.popleft()
        for i in range(4):
            nx = data[0] + dx[i]
            ny = data[1] + dy[i]
            if(nx<0 or nx>=n or ny<0 or ny>=m):
                continue
            if(maze[nx][ny]==0):
                continue
            if(maze[nx][ny]==1):
                maze[nx][ny] = maze[data[0]][data[1]] + 1
                queue.append((nx,ny))
    
    return maze[n-1][m-1]

print(bfs(0,0))



