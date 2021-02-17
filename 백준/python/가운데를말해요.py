import heapq,sys
input=sys.stdin.readline
n=int(input().rstrip());max_h=[];min_h=[]
for _ in range(n):
    num=int(input().rstrip())
    if len(max_h)==0:heapq.heappush(max_h,-num)
    else:
        if len(max_h)>len(min_h):heapq.heappush(min_h,num)
        else:heapq.heappush(max_h,-num)
        if -max_h[0]>min_h[0]:
            maxValue=-heapq.heappop(max_h)
            minValue=heapq.heappop(min_h)
            heapq.heappush(max_h,-minValue)
            heapq.heappush(min_h,maxValue)
    print(-max_h[0])