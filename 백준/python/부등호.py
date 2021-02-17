k=int(input())
data=list(map(str,input().split()))
visited=[False]*10
max_,min_='',''

def check(i,j,k):
    if k=='<': 
        return i<j
    if k=='>': 
        return i>j
    return True

def solution(n,num):
    global max_,min_
    if n==k+1:
        if not len(min_): 
            min_=num
        else: 
            max_=num
        return
    for i in range(10):
        if not visited[i]:
            if n==0 or check(num[-1],str(i),data[n-1]):
                visited[i]=True
                solution(n+1,num+str(i))
                visited[i]=False
solution(0,'')
print(max_);print(min_)