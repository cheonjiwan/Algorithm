def solution(n):
    answer = ''
    mydic={1:"1",2:"2",0:"4"}
    q=1
    r=1 
    while q!=0:
        q=n//3
        r=n%3
        if r==0: q-=1
        n=q
        answer=mydic[r]+answer
    return answer

print(solution(4))