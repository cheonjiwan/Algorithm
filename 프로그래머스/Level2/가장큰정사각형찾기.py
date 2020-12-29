from copy import deepcopy
def solution(board):
    dp=deepcopy(board);result=dp[0][0]
    for i in range(1,len(board)):
        for j in range(1,len(board[i])):
            if dp[i][j]!=0:
                dp[i][j]=min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
            result=max(result,dp[i][j])
    return result**2