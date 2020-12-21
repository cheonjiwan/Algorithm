from copy import deepcopy
def solution(number, k):
    arr=[]
    for c in number:
        while arr and arr[-1]<c:
            if k>0: arr.pop();k-=1
            else: break
        arr.append(c)
    
    while k!=0:
        arr.pop();k-=1

    return ''.join(arr)

number="4177252841"
k=4
print(solution(number,k))