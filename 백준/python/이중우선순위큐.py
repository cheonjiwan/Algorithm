from bisect import insort_left
from collections import deque

input=__import__('sys').stdin.readline
t=int(input().rstrip())
for _ in range(t):
    k=int(input().rstrip())
    q=deque()
    mydict={}
    for _ in range(k):
        order,num=input().rstrip().split()
        num=int(num)
        if order=='I':
            if num not in mydict: 
                mydict[num]=1
                insort_left(q,num)
            else: mydict[num]+=1
        elif num==1:
            if len(q)==0: continue
            item=q[-1]
            if mydict[item]==1: 
                del mydict[item]
                q.pop()
            else: mydict[item]-=1
        else:
            if len(q)==0: continue
            item=q[0]
            if mydict[item]==1:
                del mydict[item]
                q.popleft()
            else: mydict[item]-=1
    print('EMPTY') if len(q)==0 else print(q[-1],q[0])
