def solution(board, moves):
    cnt=0
    bucket=[]
    for move in moves:
        for row in range(len(board)):
            if board[row][move-1]!=0:
                if len(bucket)==0: bucket.append(board[row][move-1]);board[row][move-1]=0;break
                else: 
                    if bucket[-1]!=board[row][move-1]: bucket.append(board[row][move-1]);board[row][move-1]=0;break
                    else: bucket.pop();board[row][move-1]=0;cnt+=1;break
    return cnt*2
