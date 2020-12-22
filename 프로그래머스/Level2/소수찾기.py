from itertools import permutations
from math import sqrt,ceil
def solution(numbers):
    ans=[]
    for i in range(1,len(numbers)+1):
        combis=set(permutations(list(numbers),i));flag=False
        for combi in combis:
            num=int(''.join(combi))
            for p in range(2,num):
                if num%p==0:
                    flag=True; break

            if(not flag and num>1 and num not in ans): ans.append(num)
            else: flag=False
    return len(ans)