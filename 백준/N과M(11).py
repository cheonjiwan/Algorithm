n,m=map(int,input().split())
data=sorted(list(map(int,input().split())))
visited=[False]*n
answer=[]

def solution(depth):
    if depth==m:
        print(*answer)
        return

    pre=-1
    for i in range(n):
        if pre!=data[i]:
            pre=data[i]
            answer.append(data[i])
            solution(depth+1)
            answer.pop()
        
solution(0)