import heapq,sys
input=sys.stdin.readline
n=int(input().rstrip());q=[]
for _ in range(n):
    num=int(input().rstrip())
    if num==0:
        if len(q)==0:print(0)
        else:print(heapq.heappop(q))
    else:heapq.heappush(q,num)