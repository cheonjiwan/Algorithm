n,s=map(int,input().rstrip().split())
data=list(map(int,input().rstrip().split()))

start,end=0,1
sum_=data[0]

minLength=2e10
for start in range(n):
    while sum_<s and end<n:
        sum_+=data[end]
        end+=1
    
    if sum_>=s:
        minLength=min(minLength,end-start)
    sum_-=data[start]
print(0) if minLength==2e10 else print(minLength)