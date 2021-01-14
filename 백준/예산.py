input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
n=int(input().rstrip())
data=sorted(list(MIS()))
m=int(input().rstrip())
l,r=0,data[-1];answer=0
while l<=r:
    total=0
    mid=(l+r)//2
    for cost in data:
        if cost<mid: total+=cost
        else: total+=mid
    
    if total>m: r=mid-1
    else: l=mid+1;answer=mid
print(answer)