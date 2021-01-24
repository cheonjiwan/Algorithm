import sys
from bisect import bisect_left,bisect_right
sys.setrecursionlimit(10**5)

n=int(input())
data=sorted(list(map(int,input().split())))
m=int(input())
find=list(map(int,input().split()))

def binarySearch(l,r,x):
    if l>r: return False
    mid=(l+r)//2
    if data[mid]==x: return True
    elif x<data[mid]: return binarySearch(l,mid-1,x)
    elif x>data[mid]: return binarySearch(mid+1,r,x)


for i in range(m):
    if binarySearch(0,len(data)-1,find[i]): print(1)
    else: print(0)