n,m = map(int,input().split(" "))

x,y,direction = map(int,input().split(" "))

d = [[0 for col in range(n)] for row in range(m)]

# 북,서,남,동
dx = [-1,0,1,0]
dy = [0,-1,0,1]

map_arr = []
for i in range(n):
    input_data = list(map(int,input().split(" ")))
    map_arr.append(input_data)

def turn_left():
    global direction
    direction -=1
    if direction == -1:
        direction = 3

count = 1
turn_time = 0

while True:
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    if(d[nx][ny]==0 and map_arr[nx][ny]==0):
        d[nx][ny]=1
        x = nx
        y = ny
        turn_time +=1
        count +=1
        continue
    else:
        turn_time +=1

    if(turn_time == 4):
        nx = x - dx[direction]
        ny = y - dy[direction]
        if(map_arr[nx][ny]==0):
            x = nx
            y = ny
        else:
            break
        turn_time = 0

print(count)
        
