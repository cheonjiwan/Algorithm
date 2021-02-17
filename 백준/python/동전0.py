input=__import__('sys').stdin.readline
n,k=map(int,input().split())
coins=[]
for _ in range(n):
    coin=int(input())
    if coin<=k:
        coins.append(coin)
coins=sorted(coins,reverse=True)
cnt=0
idx=0
while True:
    if k==0: print(cnt);break
    if coins[idx]<=k: 
        cnt+=1
        k=k-coins[idx]
    else: idx+=1
