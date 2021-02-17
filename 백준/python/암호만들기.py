from itertools import combinations,permutations

l,c=map(int,input().split())
char=sorted(list(map(str,input().split())))
mo=['a','e','i','o','u']
combis=list(combinations(char,l))

for combi in combis:
    cnt=0;cnt2=0
    for tmp in combi:
        if tmp in mo: cnt+=1
        else: cnt2+=1
    if cnt>=1 and cnt2>=2: print(''.join(combi))