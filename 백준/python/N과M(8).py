n,m=map(int,input().split())
data=sorted(list(map(int,input().split())))
answer=[]

def solution(depth):
    if depth==m:
        print(*answer)
        return
    
    for i in range(len(data)):
        if not answer:
            answer.append(data[i])
            solution(depth+1)
            answer.pop()
        elif answer[-1]<=data[i]:
            answer.append(data[i])
            solution(depth+1)
            answer.pop()

solution(0)