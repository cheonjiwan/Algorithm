from bisect import bisect_left,bisect_right

input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n=int(input().rstrip())
data=sorted(list(MIS()))
m=int(input().rstrip())
find_num=list(MIS())

def find(arr,x):
    l=bisect_left(arr,x)
    r=bisect_right(arr,x)
    return r-l

for num in find_num:
    print(find(data,num),end=' ')
