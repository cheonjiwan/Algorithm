def solution(d, budget):
    d=sorted(d);cnt=0
    for num in d:
        budget-=num
        if budget>=0: cnt+=1
        else: break
    return cnt

d=[2,2,3,3]
budget=10
solution(d,budget)