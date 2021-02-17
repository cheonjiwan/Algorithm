n=int(input());data=[]
for _ in range(n):
    data.append(list(map(str,input())))

board=[[False for _ in range(n)] for _ in range(n)]
for k in range(n):
    for i in range(n):
        for j in range(n):
            if i==j: continue
            if data[i][j]=='Y' or (data[i][k]=='Y' and data[k][j]=='Y'):
                board[i][j]=True

result=-2e10
for row in board:
    cnt=0
    for col in row:
        if col==1: cnt+=1
    result=max(result,cnt)
print(result)