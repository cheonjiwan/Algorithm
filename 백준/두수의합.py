import sys
input=sys.stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n=int(input().rstrip())
data=sorted(list(MIS()))
x=int(input().rstrip())

l,r=0,n-1
cnt=0

while l<r:
    two_sum=data[l]+data[r]
    if two_sum<x:
        l+=1
        continue
    elif two_sum==x: cnt+=1
    r-=1

print(cnt)