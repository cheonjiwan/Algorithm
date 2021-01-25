n,k=map(int,input().split())
data=[i for i in range(1,n+1)]
result=[]
idx=0
for _ in range(n):
    idx=(idx+k-1)%len(data)
    result.append(data.pop(idx))
    
print('<',end='')
for num in result:
    if num==result[-1]:
        print(num,end='')
    else: print('{0}, '.format(num),end='')
print('>')
