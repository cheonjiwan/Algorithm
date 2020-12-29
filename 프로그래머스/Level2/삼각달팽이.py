def solution(n):
    arr=[[0 for _ in range(n)] for _ in range(n)]
    row,col=-1,0;num=1
    for i in range(n):
        for _ in range(i,n):
            if i%3==0: row+=1
            elif i%3==1: col+=1
            elif i%3==2: row-=1;col-=1
            arr[row][col]=num;num+=1
    answer=[]
    for row in arr:
        for col in row:
            if col!=0: answer.append(col)
    return answer

n=6
print(solution(n))