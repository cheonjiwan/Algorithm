import sys
input = sys.stdin.readline

n = int(input().rstrip())
data = list(map(int,input().split()))

dp = [0]*(len(data))
dp[0] = data[0]
maxValue = data[0]

for i in range(1,n):
    dp[i] = data[i]
    dp[i] = max(dp[i],dp[i-1]+data[i])
    maxValue = max(maxValue,dp[i])

print(maxValue)