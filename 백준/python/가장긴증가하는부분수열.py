input=__import__('sys').stdin.readline
L=lambda:list(map(int,input().rstrip().split()))
n=int(input().rstrip())
data=L()

dp=[0]*n
for i in range(n):
    minV=0
    for j in range(i):
        if data[i]>data[j]:
            minV=max(minV,dp[j])
    dp[i]=minV+1
print(max(dp))