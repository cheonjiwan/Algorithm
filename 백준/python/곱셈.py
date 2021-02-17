a,b,c=map(int,input().split())
if b==0: print(1)
else:
    n=pow(a,b//2,c)
    if b%2==0: print((n*n)%c)
    else: print((n*n*a)%c)