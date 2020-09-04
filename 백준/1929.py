from math import sqrt,ceil

flag=0
m,n = map(int,input().split())

check = [False]*(n+1) 

for i in range(2,int(sqrt(n))+1):
    for j in range(i+i,n+1,i):
        check[j]=True
check[1]=True
for i in range(m,n+1):
    if(check[i]==False):
        print(i)
    