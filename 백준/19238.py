import sys
input = sys.stdin.readline

n,m,fuel = map(int,input().split())
space = [[0]*(n+1) for _ in range(n+1)]

for _ in range(n):
    

now_x,now_y = map(int,input().split())

for _ in range(m):
    start_x,start_y,end_x,end_y = map(int,input().split())
    space[start_x][start_y]=3
    space[end_x][end_y]=9

print(space)
    


    



