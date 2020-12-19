def solution(x):
    sum_=0;tmp=x
    while tmp!=0:
        sum_+=(tmp%10)
        tmp-=tmp%10
        tmp//=10
    if x%sum_==0: return True
    else: return False