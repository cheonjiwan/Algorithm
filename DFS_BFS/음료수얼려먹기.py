from collections import deque

dI = [-1, 0, 1, 0];
dJ = [0, 1, 0, -1];

n,m = map(int,input().split())
graph = []
for i in range(n):
    graph.append(list(map(int, input())))

visit = [[False for col in range(m)] for row in range(n)]

dqueue = deque()
cnt = 0
for i in range(n) :
    for j in range(m) :
        if(graph[i][j] == 0 and visit[i][j] == False) :
          dqueue.append([i, j])
          cnt += 1
          visit[i][j] = True;
          while dqueue : 
              point = dqueue.popleft()
              ni = point[0]
              nj = point[1]
              for k in range (4) :
                  tmpI = ni + dI[k]
                  tmpJ = nj + dJ[k]
                  if(tmpI >= 0  and tmpI < n and tmpJ >= 0 and tmpJ < m):
                      if(graph[tmpI][tmpJ] == 0 and visit[tmpI][tmpJ] == False) :
                        visit[tmpI][tmpJ] = True
                        dqueue.append([tmpI, tmpJ])

              
print(cnt)



            
                
            

