n,m=map(int,input().split())
visited=[False]*(n+1)
use=[False]*(n+1)
answer=[]

def solution(depth,num):
    if depth==m:
        print(*answer)
        return
    
    for i in range(1,n+1):
        if not visited[i]:
            visited[i]=True
            if not answer:
                answer.append(i)
                solution(depth+1,i)
                answer.pop()
            elif answer[-1]<i:
                answer.append(i)
                solution(depth+1,i)
                answer.pop()
            visited[i]=False

solution(0,0)