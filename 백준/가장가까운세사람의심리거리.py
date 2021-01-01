from itertools import combinations
t=int(input())
for _ in range(t):
    n=int(input());people=list(input().split())
    if n>=33:print(0)
    else:
        result=987654321
        for a,b,c in set(list(combinations(people,3))):
            dist=0
            for i in range(4):
                if a[i]!=b[i]: dist+=1
                if a[i]!=c[i]: dist+=1
                if b[i]!=c[i]: dist+=1
            result=min(result,dist)
        print(result)