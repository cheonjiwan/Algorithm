from itertools import permutations
input=__import__('sys').stdin.readline
MIS=lambda:map(int,input().rstrip().split())

n=int(input().rstrip())
data=list(MIS())

permus=list(permutations(data,n))

result=-2e10
for permu in permus:
    tmp=0
    for i in range(len(permu)-1):
        tmp+=abs(permu[i]-permu[i+1])
    result=max(result,tmp)
print(result)