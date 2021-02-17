from itertools import combinations
talls=[]
for _ in range(9):
    talls.append(int(input()))
combis=list(combinations(talls,7))
for combi in combis:
    sum_=0
    for item in combi:
        sum_+=item
    if sum_==100:
        for num in sorted(combi):
            print(num)
        break