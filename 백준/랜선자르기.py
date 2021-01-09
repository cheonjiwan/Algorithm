input=__import__('sys').stdin.readline
k,n=map(int,input().rstrip().split());lan=[]
for _ in range(k):
    lan.append(int(input().rstrip()))

l,r=1,2**31;ans=0
while l<=r:
    cnt=0
    mid=(l+r)//2
    for i in lan:
        if i>=mid: cnt+=i//mid

    if cnt<n: r=mid-1
    else: ans=mid;l=mid+1

print(ans)