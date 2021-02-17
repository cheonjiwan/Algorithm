from collections import deque
input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())
t=int(input())
for _ in range(t):
    n,m=MIS()
    q=deque(MIS());cnt=0
    if len(q)==1: print(1)
    else:
        while q:
            flag=True
            for i in range(1,len(q)):
                if q[0]<q[i]: flag=False;break
            if not flag:
                q.rotate(-1);m-=1
                if m==-1: m=len(q)-1
            else:
                q.popleft();cnt+=1
                if m==0: print(cnt);break
                else: m-=1