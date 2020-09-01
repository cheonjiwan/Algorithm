current = input()

moves=[(2,1),(2,-1),(-2,1),(-2,-1),(1,2),(1,-2),(-1,2),(-1,-2)]

x,y = current[0],current[1]
result=0

x = int(ord(x)) - int(ord('a')) + 1;
y = int(y)

for move in moves:
    nx = x+move[0]
    ny = y+move[1]
    if(nx>=1 and nx<=8 and ny>=1 and ny<=8):
        result+=1
print(result)

