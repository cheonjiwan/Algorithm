import sys
n=int(input())
visited=[False]*4
answer=[]

def check(s):
    length=len(s)
    start=length-1
    end=length

    for i in range(1,length//2+1):
        if s[start-i:end-i]==s[start:end]:
            return False
        start-=1
    return True

def solution(len,s):
    if len==n:
        print(s)
        sys.exit()
    else:
        for i in range(1,4):
            if check(s+str(i)):
                solution(len+1,s+str(i))
    

solution(1,'1')